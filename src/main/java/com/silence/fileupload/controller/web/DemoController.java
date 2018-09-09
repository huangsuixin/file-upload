package com.silence.fileupload.controller.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author silence
 * @version 1.0
 * @className DemoController
 * @date 2018/09/08 下午10:57
 * @description //TODO
 * @program file-save2Disk
 */
@Controller
public class DemoController {

//    @RequestMapping(value = "/demo", method = RequestMethod.GET)
//    public ModelAndView index(ModelAndView modelAndView) {
//        modelAndView.setViewName("index");
//
//        return modelAndView;
//    }

    @GetMapping
    public String ind() {
        return "demo";
    }
}
