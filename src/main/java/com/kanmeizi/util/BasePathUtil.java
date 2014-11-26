package com.kanmeizi.util;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by liuzhengyang on 2014/11/26.
 */
public class BasePathUtil {
    public static String getBasePath(HttpServletRequest request){
        String path = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath() + "/";
        return path;
    }
}
