package com.silence.fileupload.controller.api;

import com.huangsuixin.sdk.exception.ParameterException;
import com.silence.fileupload.controller.BaseController;
import com.silence.fileupload.service.IFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;

/**
 * @author silence
 * @version 1.0
 * @className FileController
 * @date 2018/08/17 下午9:38
 * @description
 * @program file-save2Disk
 */
@RestController
public class FileController extends BaseController {
    private final Logger LOGGER = LoggerFactory.getLogger(FileController.class);

    @Value("${save2Disk-dir}")
    String uploadDir;
    @Autowired
    private IFileService fileService;

    @RequestMapping(value = "/fileDir", method = RequestMethod.GET)
    public String hello() {
        return "hello world" + uploadDir;
    }

    @RequestMapping(value = "/image/upload", method = RequestMethod.POST, consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public Object fileUpload(@RequestParam("image") MultipartFile image, @RequestParam("staff") String staff, HttpServletRequest request) {
        if (image.isEmpty()) {
            throw new ParameterException("文件为空");
        }
        fileService.save(image, staff);

        return null;
    }
}
