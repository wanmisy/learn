package com.example.concurrent.controller;

import lombok.Data;

/**
 * @ClassName Result
 * @Description TODO
 * @Author missj
 * @Date 2018/12/11 10:31
 * @Version 1.0
 */
@Data
public class Result {
    private boolean success = false;
    private String message = null;

    public Result() {
    }

    public Result(boolean success, String message) {
        this.success = success;
        this.message = message;
    }
}
