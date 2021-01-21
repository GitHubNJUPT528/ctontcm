package com.cton.model;


import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "alioss")
public class OssEntity {
    private String endpoint;

    private String accessKeyId;

    private String accessKeySecret;

    private String bucketName;
}
