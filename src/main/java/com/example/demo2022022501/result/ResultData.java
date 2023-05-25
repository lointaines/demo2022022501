package com.example.demo2022022501.result;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author ASUS
 */
@Data
@AllArgsConstructor
public class ResultData<T> {
    private Integer code;
    private String msg;
    private T data;

    public ResultData(int code) {
        this.code = code;
    }

    public static <T> ResultData<T> success() {
        return new ResultData<>(ResultCode.SUCCESS);

    }

    public static <T> ResultData<T> error() {
        return new ResultData<>(ResultCode.ERROR);

    }

    public static <T> ResultData<T> success(String msg, T data) {
        return new ResultData<>(ResultCode.SUCCESS, msg, data);
    }

    public static ResultData<Object> successMsg(String msg) {
        ResultData<Object> success = ResultData.success();
        success.setMsg(msg);
        return success;
    }

    public static ResultData<Object> notFound() {
        return new ResultData<>(ResultCode.NOTFOUND);
    }
}
