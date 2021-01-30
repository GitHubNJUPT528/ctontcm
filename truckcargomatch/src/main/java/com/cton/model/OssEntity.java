package com.cton.model;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alioss")
@ApiModel(value = "Oss对象",description = "Oss对象") //需要注意必须在controller中关联实体类 才能在文档中显示
public class OssEntity {

    @ApiModelProperty("终端节点")
    private String endpoint;

    @ApiModelProperty("许可ID")
    private String accessKeyId;

    @ApiModelProperty("许可密码")
    private String accessKeySecret;

    @ApiModelProperty("bucket名")
    private String bucketName;
}
