package com.xc.study.design;

import cn.hutool.json.JSON;
import cn.hutool.json.JSONParser;
import cn.hutool.json.JSONUtil;

import java.util.HashMap;

/**
 * @author bryant
 * @date 2023/11/7
 **/
public class demo {
    public static void main(String[] args) {
        HashMap<String, Integer> stringIntegerHashMap = new HashMap<>();
        stringIntegerHashMap.put("数据1", 1);
        System.out.println(JSONUtil.parse(stringIntegerHashMap));
        String s = "{\"数据1\":1}";
    }
}
