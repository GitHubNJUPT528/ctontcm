package com.cton.web.oss;

import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.service.oss.AliOssService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin
@Api(value = "系统OSS存储模块",tags = "系统OSS存储接口")
public class AliOssController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private AliOssService aliOssService;

    @ApiOperation(value = "上传图片",notes = "上传图片")
    @PostMapping("/uploadImgFile")
    public ResultDTO uploadImgFile(MultipartFile file){
        String upload = aliOssService.upload(file);
        return new ResultDTO(HttpCode.SUCCESS.getCode(),upload);

    }

    @ApiOperation(value = "删除图片",notes = "删除图片")
    @PostMapping("/deleteImgFile")
    public ResultDTO deleteImgFile(String fileUrl) {
        try {
            String[] split = fileUrl.split(".com/");
            aliOssService.deleteFile(split[1]);
            return new ResultDTO(HttpCode.FAIL.getCode(),"删除成功");
        } catch (Exception e) {
            logger.info("删除失败",e);
            return new ResultDTO(HttpCode.SUCCESS.getCode(), "删除失败");
        }
    }
}
