package com.example.springwebdemon;

import java.io.Serializable;

/**
 * 通用rest响应
 *
 * @param <T>
 * @author yuqin
 */
public class RestResponse<T> implements Serializable {

    /**
     * 成功的状态码
     */
    public final static int SUCCESS_CODE = 0;

    public static <T> RestResponse<T> data(T data) {
        return new RestResponse<>(0, null, data);
    }

    public static <T> RestResponse<T> fail(int code, String msg) {
        return new RestResponse<>(code, msg, null);
    }

    public static <T> RestResponse<T> fail(int code, String msg, String exMsg) {
        return new RestResponse<>(code, msg, exMsg, null);
    }

    public static <T> RestResponse<T> success() {
        return new RestResponse<>(0, null, null);
    }

    /**
     * 错误码 0 成功， >0 失败
     */
    private int code;
    /**
     * 错误信息
     */
    private String msg;

    /**
     * 异常信息
     */
    private String exMsg;

    /**
     * 是否隐藏错误提示
     */
    private Boolean hideMsg;

    /**
     * 数据
     */
    private T data;

    public RestResponse() {
    }

    public RestResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResponse(int code, String msg, String exMsg, T data) {
        this.code = code;
        this.msg = msg;
        this.exMsg = exMsg;
        this.data = data;
    }

    public RestResponse(int code, String msg, String exMsg, Boolean hideMsg, T data) {
        this.code = code;
        this.msg = msg;
        this.exMsg = exMsg;
        this.data = data;
        this.hideMsg = hideMsg;
    }

    public RestResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getExMsg() {
        return exMsg;
    }

    public void setExMsg(String exMsg) {
        this.exMsg = exMsg;
    }

    public Boolean getHideMsg() {
        return hideMsg;
    }

    public void setHideMsg(Boolean hideMsg) {
        this.hideMsg = hideMsg;
    }
}
