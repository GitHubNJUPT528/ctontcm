package com.cton.handler;


import com.cton.constants.ResultDTO;
import com.cton.enums.HttpCode;
import com.cton.utils.ResultUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalExceptionHandler {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * 全局异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResultDTO error(Exception e){
        logger.info("系统异常",e);
        return ResultUtil.error(HttpCode.EXCEPTION.getCode(),"系统异常");
    }

    /**
     * 业务异常处理
     * @param e
     * @return
     */
    @ExceptionHandler(BusinessException.class)
    @ResponseBody
    public ResultDTO error(BusinessException e){
        logger.info("系统异常",e);
        return ResultUtil.error(e.getCode(),e.getErrMsg());
    }

}
