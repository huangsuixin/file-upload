package com.silence.fileupload;

/**
 * @author silence
 * @version 1.0
 * @className Demo
 * @date 2018/08/18 下午10:38
 * @description //TODO
 * @program file-upload
 */
public class Demo {

    public void doSomething(Callback callback) {
        System.out.println("执行一些操作");
        // 中间插入上层传入的代码块
        callback.execute();
        System.out.println("再执行一些操作");
    }
}
