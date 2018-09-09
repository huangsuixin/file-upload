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
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.multipart.MultipartException;

/**
 * @author silence
 * @version 1.0
 * @className GlobalExceptionHandler
 * @date 2018/08/17 下午10:15
 * @description 全局异常处理
 * @program file-save2Disk
 */
@RestControllerAdvice
public class GlobalExceptionHandler {
    private final Logger LOGGER = LoggerFactory.getLogger(GlobalExceptionHandler.class);

    @ExceptionHandler(ParameterException.class)
    public ActionResult handleParameterException(ParameterException e) {
        LOGGER.info(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    @ExceptionHandler(BusinessException.class)
    public ActionResult handleBusinessException(BusinessException e) {
        LOGGER.info(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.BAD_REQUEST.value());
        return result;
    }

    @ExceptionHandler(MultipartException.class)
    public ActionResult handleMultipartException(MultipartException e) {
        LOGGER.error(e.getMessage(), e);
        return new ActionResult<>(false, e.getMessage());
    }

    @ExceptionHandler(value = RuntimeException.class)
    public ActionResult handleRuntimeException(RuntimeException e) {
        LOGGER.error(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }

    @ExceptionHandler(value = Exception.class)
    public ActionResult handleException(Exception e) {
        LOGGER.error(e.getMessage(), e);
        ActionResult result = new ActionResult(false, e.getMessage());
        result.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        return result;
    }
}
