package com.spring.util;

import com.spring.exception.UserNotFoundException;

public class CommonUtil {

    public static void handleExceptionMessage(int id){
        throw new UserNotFoundException("user id: "+id+" is not exists...");
    }

    public static void handleExceptionMessage(String name){
        throw new UserNotFoundException("user name: "+name+" is not exists...");
    }
}
