package com.xc.study.hashmap;

import java.util.HashMap;
import java.util.Objects;

/**
 * @author bryant
 * @date 2025/8/19
 **/
public class MapTest {
    public static void main(String[] args) {
//        BryantMap<String, String> map = new BryantMap<>();
        NewMap<String, String> map = new NewHashMap<>();
        map.put("Aa", "1");
        map.put("BB", "2");
        map.put("cc", "3");
        map.replaceAllKey((k, v) -> v);
        map.forEach((k, v) -> System.out.println(k + ":" + v));
//        int hash1 = "Aa".hashCode();
//        int hash2 = "BB".hashCode();
//        System.out.println(hash1);
//        System.out.println(hash2);
//        System.out.println(map.get("BB"));
//        System.out.println(sout("james"));
    }

    public static String sout(String name) {
        Objects.requireNonNull(name);
        System.out.println(name);
        return "bryant";
    }
}
