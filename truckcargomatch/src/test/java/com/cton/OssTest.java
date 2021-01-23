package com.cton;


import com.cton.model.OssEntity;
import com.cton.service.oss.AliOssService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest(classes = TruckcargomatchApplication.class)
public class OssTest {

    @Autowired
    private OssEntity ossEntity;

    @Autowired
    private AliOssService aliOssService;

    @Test
    public void contextLoads(){

    }
}
