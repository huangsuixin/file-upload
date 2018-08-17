package com.silence.fileupload.config;

import com.silence.fileupload.entity.ActionResult;
import com.silence.fileupload.exception.BusinessException;
import com.silence.fileupload.exception.ParameterException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author silence
 * @version 1.0
 * @className GlobalExceptionHandler
 * @date 2018/08/17 下午10:15
 * @description 全局异常处理
 * @program file-upload
 */
@ControllerAdvice
public class GlobalExceptionHandler {
    private final Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ResponseBody
    @ExceptionHandler(ParameterException.class)
    public ActionResult handleParameterException(ParameterException e) {
        logger.info(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ActionResult handleBusinessException(BusinessException e) {
        logger.info(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    @ExceptionHandler(value = RuntimeException.class)
    @ResponseBody
    public ActionResult handleRuntimeException(RuntimeException e) {
        logger.error(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseBody
    public ActionResult handleException(Exception e) {
        logger.error(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }
}
