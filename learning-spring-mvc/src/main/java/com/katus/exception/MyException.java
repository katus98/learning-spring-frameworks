package com.katus.exception;

/**
 * 自定义异常类
 * @author Keran Sun (katus)
 * @version 1.0, 2020-08-30
 */
public class MyException extends Exception {
    private String message;

    public MyException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
