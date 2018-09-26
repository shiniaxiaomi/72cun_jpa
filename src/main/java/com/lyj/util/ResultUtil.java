package com.lyj.util;

import com.lyj.entity.Result;

/**
 * Created by 陆英杰
 * 2018/9/27 0:38
 */
public class ResultUtil {

    //返回成功
    public static Result success(Object data){
        Result result=new Result();
        result.setCode(0);
        result.setMassage("成功");
        result.setData(data);
        return result;
    }

    //返回成功
    public static Result success(String message){
        return success(message,null);
    }

    //返回成功
    public static Result success(String message,Object data){
        Result result=new Result();
        result.setCode(0);
        result.setMassage("成功:"+message);
        result.setData(data);
        return result;
    }

    //返回成功
    public static Result success(){
        return success(null);
    }

    //返回失败(封装异常)
    public static Result error(String massage,Object data){
        Result result=new Result();
        result.setCode(1);
        result.setMassage("失败:"+massage);
        result.setData(data);
        return result;
    }

    //返回失败
    public static Result error(String massage){
        return error(massage,null);
    }

}
