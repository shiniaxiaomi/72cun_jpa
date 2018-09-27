package com.lyj.util;

/**
 * Created by 陆英杰
 * 2018/9/27 23:40
 */

/**
 * 字符串工具类
 */
public class StringUtil {


    public static boolean isNotEmpty(String str){
        if(str==null || "".equals(str)){
            return false;
        }else{
            return true;
        }
    }
}
