package com.silence.fileupload.service;

import com.silence.fileupload.entity.dto.FileDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;

/**
 * @author silence
 * @version 1.0
 * @className IFileService
 * @date 2018/09/08 下午9:52
 * @description
 * @program file-save2Disk
 */
public interface IFileService {
    /**
     * 文件上传
     *
     * @param sourceFile 上传的文件
     * @param targetFile 文件储存的目录
     * @return
     */
    void save2Disk(MultipartFile sourceFile, File targetFile);

    /**
     * 储存file信息到数据库
     *
     * @param fileDTO
     */
    void save(FileDTO fileDTO);

    /**
     * 保存文件
     * 1. 储存到硬盘
     * 2. 信息储存到数据库
     *
     * @param file
     * @param staff
     */
    void save(MultipartFile file, String staff);
}
