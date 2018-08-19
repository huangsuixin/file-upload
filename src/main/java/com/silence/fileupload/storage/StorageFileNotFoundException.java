package com.silence.fileupload.storage;

/**
 * @author silence
 * @version 1.0
 * @className StorageFileNotFoundException
 * @date 2018/08/18 下午6:10
 * @description //TODO
 * @program file-upload
 */
public class StorageFileNotFoundException extends RuntimeException {
    public StorageFileNotFoundException() {
        super();
    }

    public StorageFileNotFoundException(String message) {
        super(message);
    }

    public StorageFileNotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public StorageFileNotFoundException(Throwable cause) {
        super(cause);
    }

    protected StorageFileNotFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
