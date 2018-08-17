package com.silence.fileupload.controller;

import com.silence.fileupload.exception.ParameterException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author silence
 * @version 1.0
 * @className HelloController
 * @date 2018/08/17 下午9:38
 * @description //TODO
 * @program file-upload
 */
@RestController
public class HelloController extends BaseController {

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String hello(String name, Integer age) {

        if (name.length() >= 10) {
            throw new ParameterException("名字不能大于10字符");
        }
        return "hello world";
    }
}
