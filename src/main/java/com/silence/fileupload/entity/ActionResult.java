package com.silence.fileupload.entity;

/**
 * @author suixin
 * @version 1.0
 * @className ActionResult
 * @date 2018/8/2 10:14
 * @description 相应结果封装
 * @program codecount
 */
public class ActionResult {
    private boolean success;

    private String message;

    private Object data;

    private Integer code;


    public ActionResult() {
    }

    public ActionResult(boolean success) {
        this(success, null, null);
    }

    public ActionResult(boolean success, String message) {
        this(success, message, null);
    }

    public ActionResult(boolean success, String message, Object data) {
        this.success = success;
        this.message = message;
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}

