package com.cton.service.oss;

import com.aliyun.oss.OSS;
import com.aliyun.oss.OSSClientBuilder;
import com.aliyun.oss.model.*;
import com.cton.model.OssEntity;
import org.joda.time.DateTime;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Date;
import java.util.UUID;


@Service
public class AliOssServiceImpl implements AliOssService, InitializingBean {

    @Autowired
    private OssEntity ossEntity;

    /**
     * 创建类的时候就需要把属性装载好
     */
    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;


    /**
     * 初始化Bean之后会执行的操作
     * @throws Exception
     */
    @Override
    public void afterPropertiesSet() throws Exception {
        endpoint = ossEntity.getEndpoint();
        accessKeyId = ossEntity.getAccessKeyId();
        accessKeySecret = ossEntity.getAccessKeySecret();
        bucketName = ossEntity.getBucketName();
    }

    /**
     * 创建存储空间
     */
    @Override
    public void createBucket() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
        //判断bucketName是否存在
        if(ossClient.doesBucketExist(bucketName)){
            throw new RuntimeException(bucketName+"在对象存储的bucket列表种已经存在");
        }
        // 创建存储空间。
        ossClient.createBucket(bucketName);
        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 上传文件
     *
     * @param file
     * @return
     */
    @Override
    public String upload(MultipartFile file) {

        //上传的地址
        String uploadUrl = null;
        try{
            // 创建OSSClient实例。
            OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);
            //判断bucketName是否存在
            if(!ossClient.doesBucketExist(bucketName)){
                ossClient.createBucket(bucketName);
                //设置bucket
                ossClient.setBucketAcl(bucketName, CannedAccessControlList.PublicRead);
            }
            //获取上传的文件流
            InputStream inputStream = file.getInputStream();

            //构建日期的文件夹路径  avatar/2021/1/21/文件名
            String datePath= new DateTime().toString("yyyy/MM/dd");

            //获取上传文件的全名称
            String original = file.getOriginalFilename();

            //获取UUID
            String fileName = UUID.randomUUID().toString().replaceAll("-", "");

            //获取上传文件的拓展名
            String fileType = original.substring(original.lastIndexOf("."));

            //拼接文件名称
            String newName = fileName + fileType;

            //生成文件夹
            fileName = datePath + "/" + newName;

            //如果想要实现图片预览的效果，一定要设置以下极点
            //1.设置文件的ACL（权限）  要么是公共读，要么是公共读写
            //2.一定要设置文本类型（image/jpg等）
            ObjectMetadata objectMetadata = new ObjectMetadata();
            //设置公共读权限
            objectMetadata.setObjectAcl(CannedAccessControlList.PublicRead);
            objectMetadata.setContentType(getcontentType(fileType));

            //每次上传得到的名字肯定是不相同的，在java种怎么让每次生成的名字不相同
            //uuid Reidis是分布式 雪花算法 zookeeper分布式  使用uuid 文件格式yyyy/MM/dd+uuid

            ossClient.putObject(bucketName, fileName, inputStream,objectMetadata);

            //关闭OSSClient
            ossClient.shutdown();

            //默认十年不过期
            Date expiration = new Date(System.currentTimeMillis()+3600L * 1000 * 24 * 365 * 10);
            //bucket名称  文件名  过期时间
            uploadUrl = ossClient.generatePresignedUrl(bucketName,fileName,expiration).toString();

            //获取url地址
            //uploadUrl = "https://" + bucketName + "." + endpoint + "/" + fileName;

        }catch (Exception e){
            e.printStackTrace();
        }
        return uploadUrl.substring(0,uploadUrl.indexOf("?"));
    }

    /**
     * 下载文件
     *
     * @param fileName
     * @throws IOException
     */
    @Override
    public void download(String fileName) throws IOException {
        // <yourObjectName>从OSS下载文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = fileName;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 调用ossClient.getObject返回一个OSSObject实例，该实例包含文件内容及文件元信息。
        OSSObject ossObject = ossClient.getObject(bucketName, objectName);
        // 调用ossObject.getObjectContent获取文件输入流，可读取此输入流获取其内容。
        InputStream content = ossObject.getObjectContent();
        if (content != null) {
            BufferedReader reader = new BufferedReader(new InputStreamReader(content));
            while (true) {
                String line = reader.readLine();
                if (line == null) break;
                System.out.println("\n" + line);
            }
            // 数据读取完成后，获取的流必须关闭，否则会造成连接泄漏，导致请求无连接可用，程序无法正常工作。
            content.close();
        }

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 列举文件
     */
    @Override
    public void listFile() {
        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // ossClient.listObjects返回ObjectListing实例，包含此次listObject请求的返回结果。
        ObjectListing objectListing = ossClient.listObjects(bucketName);
        // objectListing.getObjectSummaries获取所有文件的描述信息。
        for (OSSObjectSummary objectSummary : objectListing.getObjectSummaries()) {
            System.out.println(" - " + objectSummary.getKey() + "  " +
                    "(size = " + objectSummary.getSize() + ")");
        }

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * 删除文件
     *
     * @param fileName
     */
    @Override
    public void deleteFile(String fileName) {
        // <yourObjectName>表示删除OSS文件时需要指定包含文件后缀在内的完整路径，例如abc/efg/123.jpg。
        String objectName = fileName;

        // 创建OSSClient实例。
        OSS ossClient = new OSSClientBuilder().build(endpoint, accessKeyId, accessKeySecret);

        // 删除文件。
        ossClient.deleteObject(bucketName, objectName);

        // 关闭OSSClient。
        ossClient.shutdown();
    }

    /**
     * Description: 判断OSS服务文件上传时文件的contentType
     *
     * @param FilenameExtension 文件后缀
     * @return String
     */
    public static String getcontentType(String FilenameExtension) {
        if (FilenameExtension.equalsIgnoreCase(".bmp")) {
            return "image/bmp";
        }
        if (FilenameExtension.equalsIgnoreCase(".gif")) {
            return "image/gif";
        }
        if (FilenameExtension.equalsIgnoreCase(".jpeg") ||
                FilenameExtension.equalsIgnoreCase(".jpg") ||
                FilenameExtension.equalsIgnoreCase(".png")) {
            return "image/jpeg";
        }
        if (FilenameExtension.equalsIgnoreCase(".html")) {
            return "text/html";
        }
        if (FilenameExtension.equalsIgnoreCase(".txt")) {
            return "text/plain";
        }
        if (FilenameExtension.equalsIgnoreCase(".vsd")) {
            return "application/vnd.visio";
        }
        if (FilenameExtension.equalsIgnoreCase(".pptx") ||
                FilenameExtension.equalsIgnoreCase(".ppt")) {
            return "application/vnd.ms-powerpoint";
        }
        if (FilenameExtension.equalsIgnoreCase(".docx") ||
                FilenameExtension.equalsIgnoreCase(".doc")) {
            return "application/msword";
        }
        if (FilenameExtension.equalsIgnoreCase(".xml")) {
            return "text/xml";
        }
        return "image/jpeg";
    }

}
