package com.silence.fileupload.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author silence
 * @version 1.0
 * @className UUIDGenerator
 * @date 2018/08/18 上午11:35
 * @description UUIDGenerator
 * @program file-upload
 */
public class UUIDGenerator {
    private final static Logger logger = LoggerFactory.getLogger(UUIDGenerator.class);

    /**
     * 生成32位随机的UUID
     *
     * @return
     */
    public static String next() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString().replace("-", "");
    }
}
