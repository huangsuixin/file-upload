package com.silence.fileupload.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author silence
 * @version 1.0
 * @className FileDTO
 * @date 2018/08/18 下午12:11
 * @description FileDto
 * @program file-upload
 */
@Data
@Builder
public class FileDTO {
    private String uuid;
    private String url;
    private Boolean isDeleted;
    private Boolean isEnable;
    private Long fileSize;
    private String type;
    private String staff;
}
