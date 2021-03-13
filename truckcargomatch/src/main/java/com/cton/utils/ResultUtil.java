package com.cton.utils;

import com.cton.constants.ResultDTO;

public class ResultUtil {

    public static ResultDTO success() {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(1001);
        resultDTO.setMsg("成功");
        return resultDTO;
    }

    public static ResultDTO success(String msg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(1001);
        resultDTO.setMsg(msg);
        return resultDTO;
    }

    public static ResultDTO success(String msg, Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(1001);
        resultDTO.setMsg(msg);
        resultDTO.setData(object);
        return resultDTO;
    }

    public static ResultDTO success(Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(1001);
        resultDTO.setMsg("成功");
        resultDTO.setData(object);
        return resultDTO;
    }

    public static ResultDTO error(Integer code, String msg) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMsg(msg);
        return resultDTO;
    }

    public static ResultDTO error(Integer code, String msg, Object object) {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setCode(code);
        resultDTO.setMsg(msg);
        resultDTO.setData(object);
        return resultDTO;
    }
}
