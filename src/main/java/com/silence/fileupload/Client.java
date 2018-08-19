package com.silence.fileupload;

/**
 * @author silence
 * @version 1.0
 * @className Client
 * @date 2018/08/18 下午10:46
 * @description //TODO
 * @program file-upload
 */
public class Client {

    public static void main(String[] args) {
        Demo demo = new Demo();
        demo.doSomething(() -> {
            System.out.println("上层模块的操作");
        });
    }
}
