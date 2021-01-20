package com.cton.utils;

import com.mysql.cj.util.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

public class UUIDUtils {

    /**
     * 根据指定前缀生成ID
     * @param preStr
     * @return
     */
    public static String buildId(String preStr){

        if (StringUtils.isNullOrEmpty(preStr)){
            return null;
        }
        //获取UUID
        String uuid = UUID.randomUUID().toString().replaceAll("-", "").toUpperCase();
        //生成后缀
        long suffix = Math.abs(uuid.hashCode() % 100000000);
        SimpleDateFormat sdf = new SimpleDateFormat("yyMMdd");
        String time = sdf.format(new Date(System.currentTimeMillis()));
        //生成前缀
        long prefix = Long.parseLong(time) * 100000000;
        String userId = preStr + String.valueOf(prefix + suffix);
        return userId;
    }
}
