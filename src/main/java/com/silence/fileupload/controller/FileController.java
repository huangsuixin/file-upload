package com.silence.fileupload.controller;

import com.silence.fileupload.dto.FileDTO;
import com.silence.fileupload.exception.BusinessException;
import com.silence.fileupload.exception.ParameterException;
import com.silence.fileupload.util.UUIDGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * @author silence
 * @version 1.0
 * @className FileController
 * @date 2018/08/17 下午9:38
 * @description
 * @program file-upload
 */
@RestController
public class FileController extends BaseController {
    private final Logger logger = LoggerFactory.getLogger(FileController.class);

    @Value("${upload-dir}")
    String uploadDir;
    @RequestMapping(value = "/**", method = RequestMethod.GET)
    public String hello() {
        return "hello world" + uploadDir;
    }

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST)
    public Object fileUpload(@RequestParam("image") MultipartFile image, @RequestParam("staff") String staff) {
        if (image.isEmpty()) {
            throw new ParameterException("文件为空");
        }
        long size = image.getSize();
        FileDTO fileDTO = FileDTO.builder()
                .staff(staff).fileSize(size).build();

        try {
            executeUpload(image, uploadDir);
        } catch (IOException e) {
            throw new BusinessException("文件储存失败", e);
        }
        return null;
    }

    private String executeUpload(MultipartFile file, String parentFile) throws IOException {
        // 上传的文件名
        String originalFilename = file.getOriginalFilename();
        if (StringUtils.isEmpty(originalFilename)) {
            throw new ParameterException("文件名为空");
        }
        if (!originalFilename.contains(".")) {
            logger.info("文件不含有后缀--:" + originalFilename);
        }
        // 文件后缀
        String suffix = originalFilename.substring(originalFilename.lastIndexOf("."));

        // 储存的文件名
        String fileName = UUIDGenerator.next() + suffix;

        File serverFile = new File(parentFile, fileName);
        if (!serverFile.getParentFile().exists()) {
            serverFile.getParentFile().mkdir();
        }
        file.transferTo(serverFile);
        return fileName;
    }
}
