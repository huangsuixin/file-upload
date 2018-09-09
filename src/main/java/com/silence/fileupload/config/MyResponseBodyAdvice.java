package com.silence.fileupload.config;

import com.silence.fileupload.entity.ActionResult;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.io.File;

/**
 * @author suixin
 * @version 1.0
 * @className MyResponseBodyAdvice
 * @date 2018/8/2 10:11
 * @description 结果统一装配
 * @program
 */
@ControllerAdvice(basePackages = "com.silence.fileupload.controller.api")
public class MyResponseBodyAdvice implements ResponseBodyAdvice<Object> {
    private final static Logger LOGGER = LoggerFactory.getLogger(MyResponseBodyAdvice.class);
    @Override
    public boolean supports(MethodParameter returnType, Class<? extends HttpMessageConverter<?>> converterType) {
        LOGGER.debug("MyResponseBodyAdvice==>supports:" + converterType);
        LOGGER.debug("MyResponseBodyAdvice==>supports:" + returnType.getClass());
        LOGGER.debug("MyResponseBodyAdvice==>supports:"
                + MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType));
        return MappingJackson2HttpMessageConverter.class.isAssignableFrom(converterType);
    }

    @Override
    public Object beforeBodyWrite(Object body, MethodParameter returnType, MediaType selectedContentType, Class<? extends HttpMessageConverter<?>> selectedConverterType, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (body instanceof ActionResult) {
            return body;
        } else if (body instanceof File) {
            LOGGER.info("response file");
            return body;
        } else {
            LOGGER.debug("MyResponseBodyAdvice==>beforeBodyWrite:" + returnType + ", " + body);
            ActionResult<Object> result = new ActionResult<>(true);
            result.setCode(HttpStatus.OK.value());
            result.setMessage(HttpStatus.OK.getReasonPhrase());
            result.setData(body);
            body = result;
            return body;
        }
    }
}
