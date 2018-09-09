package com.silence.fileupload.service.impl;

import com.silence.fileupload.dao.FileDOMapper;
import com.silence.fileupload.domain.FileDO;
import com.silence.fileupload.entity.dto.FileDTO;
import com.silence.fileupload.exception.BusinessException;
import com.silence.fileupload.exception.ParameterException;
import com.silence.fileupload.exception.ServerException;
import com.silence.fileupload.mapstuct.FileUploadModelMapper;
import com.silence.fileupload.service.IFileService;
import com.silence.fileupload.util.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author silence
 * @version 1.0
 * @className FileServiceImpl
 * @date 2018/09/08 下午9:53
 * @description file service
 * @program file-save2Disk
 */
@Service
public class FileServiceImpl implements IFileService {
    private static final Logger LOGGER = LoggerFactory.getLogger(FileServiceImpl.class);
    @Autowired
    private FileDOMapper fileDOMapper;
    @Autowired
    private FileUploadModelMapper fileUploadModelMapper;
    @Value("${save2Disk-dir}")
    private String uploadDir;

    @Override
    public void save2Disk(MultipartFile sourceFile, File targetFile) {
        if (!targetFile.getParentFile().exists()) {
            boolean mkdir = targetFile.getParentFile().mkdir();
            if (!mkdir) {
                throw new ServerException("创建目录失败:" + targetFile.getParentFile());
            }
        }
        try {
            LOGGER.info("储存图片到硬盘");
            sourceFile.transferTo(targetFile);
        } catch (IOException e) {
            throw new BusinessException("文件储存失败", e);
        }
    }

    @Override
    public void save(FileDTO fileDTO) {
        FileDO fileDO = fileUploadModelMapper.mapFileDO(fileDTO);
        fileDO.setCreateStaff(fileDTO.getStaff());
        fileDO.setUpdateStaff(fileDTO.getStaff());
        fileDOMapper.insertSelective(fileDO);
        LOGGER.info("save fileDTO:{}" + fileDTO.toString());
    }

    @Override
    public void save(MultipartFile file, String staff) {
        LOGGER.info("目录:{}", uploadDir);
        // 上传的文件名
        String originalFilename = file.getOriginalFilename();
        if (StringUtils.isEmpty(originalFilename)) {
            throw new ParameterException("文件名为空");
        }
        if (!originalFilename.contains(".")) {
            LOGGER.warn("文件不含有后缀{}", originalFilename);
        }
        // 文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));
        // 储存的文件名
        String uuid = UUIDGenerator.next();
        String fileName = uuid + suffix;
        File targetFile = new File(uploadDir, fileName);

        save2Disk(file, targetFile);
        save(FileDTO.builder().uuid(uuid).fileSize(file.getSize()).staff(staff).url(uploadDir + fileName).build());
    }
}
