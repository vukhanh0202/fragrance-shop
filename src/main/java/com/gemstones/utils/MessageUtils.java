package com.gemstones.utils;

import java.util.HashMap;
import java.util.Map;

public class MessageUtils {

    public static Map<String,String> getMessage(String message){
        Map<String,String> result = new HashMap<>();
        if (message.equals("update_success")){
            result.put("message", "Thành công");
            result.put("alert", "success");
        } else if (message.equals("insert_success")) {
            result.put("message", "Thành công");
            result.put("alert", "success");
        } else if (message.equals("delete_success")) {
            result.put("message", "Thành công");
            result.put("alert", "success");
        } else if (message.equals("error_system")) {
            result.put("message", "Thất bại");
            result.put("alert", "danger");
        }
        return result;
    }
}
