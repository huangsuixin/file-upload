package com.silence.fileupload.entity.dto;

import lombok.Builder;
import lombok.Data;

/**
 * @author silence
 * @version 1.0
 * @className FileDTO
 * @date 2018/08/18 下午12:11
 * @description FileDto
 * @program file-save2Disk
 */
@Data
@Builder(toBuilder = true)
public class FileDTO {
    private String uuid;
    private String url;
    private Boolean isDeleted;
    private Boolean isEnable;
    private Long fileSize;
    private String type;
    private String staff;

    public FileDTO() {
    }

    public FileDTO(String uuid, String url, Boolean isDeleted, Boolean isEnable, Long fileSize, String type, String staff) {
        this.uuid = uuid;
        this.url = url;
        this.isDeleted = isDeleted;
        this.isEnable = isEnable;
        this.fileSize = fileSize;
        this.type = type;
        this.staff = staff;
    }
}
