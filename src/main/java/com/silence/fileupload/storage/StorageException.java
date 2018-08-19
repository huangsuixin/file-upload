package com.silence.fileupload.storage;

/**
 * @author silence
 * @version 1.0
 * @className StorageException
 * @date 2018/08/18 下午6:09
 * @description //TODO
 * @program file-upload
 */
public class StorageException extends RuntimeException {
    public StorageException() {
        super();
    }

    public StorageException(String message) {
        super(message);
    }

    public StorageException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageException(Throwable cause) {
        super(cause);
    }

    protected StorageException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
