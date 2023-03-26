package com.xc.study.functionalInterface;

import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * @author xc
 * @date 2023/3/26 22:42
 **/
public class Demo {
    public static void main(String[] args) {
        //消费型Consumer 有参数，无返回
        Consumer<String> consumer = System.out::println;
        Consumer<String> consumer1 = (String s)->{
            System.out.println(s.length());
        };
        consumer.andThen(consumer1).accept("我是consumer函数式接口");
        //供应型Supplier 无参数，有返回值
        Supplier<Integer> supplier = () -> {return new Random().nextInt(10);};
        System.out.println(supplier.get());
        //功能型Function 有参数也有返回结果
        Function<String,Integer> function = Integer::valueOf;
        System.out.println(function.apply("111"));
        //断言型Predicate 有参数返回值boolean
        Predicate<String> predicate = "222"::equals;
        System.out.println(predicate.equals("222"));
        System.out.println("222".equals("222"));
    }
}
