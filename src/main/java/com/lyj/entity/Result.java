package com.lyj.entity;

/**
 * Created by 陆英杰
 * 2018/9/27 0:35
 */

/**
 * http请求返回的最外层对象
 */
public class Result<T> {

    //错误码
    private Integer code;
    //提示信息
    private String massage;
    //具体内容
    private T data;

    public Result() {
    }

    public Result(Integer code, String massage, T data) {
        this.code = code;
        this.massage = massage;
        this.data = data;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMassage() {
        return massage;
    }

    public void setMassage(String massage) {
        this.massage = massage;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
