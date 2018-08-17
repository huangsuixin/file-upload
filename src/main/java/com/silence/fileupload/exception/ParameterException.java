package com.silence.fileupload.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * @author silence
 * @version 1.0
 * @className ParameterException
 * @date 2018/08/17 下午10:12
 * @description 参数错误异常
 * @program file-upload
 */
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ParameterException extends RuntimeException {
    public ParameterException() {
        super();
    }

    public ParameterException(String message) {
        super(message);
    }

    public ParameterException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParameterException(Throwable cause) {
        super(cause);
    }

    protected ParameterException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
