package cn.xiaochangwei.summarize.basic.entity;

import lombok.Data;

import java.math.BigDecimal;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Data
public class Apple {
    private Integer id;
    private String name;
    private BigDecimal money;
    private Integer num;

    public Apple(Integer id, String name, BigDecimal money, Integer num) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.num = num;
    }

    public static void main(String[] args) {
//        List<Apple> list = new ArrayList<>();//存放apple对象集合
//
//        Apple apple1 = new Apple(1, "苹果1", new BigDecimal("3.25"), 10);
//        Apple apple12 = new Apple(1, "苹果2", new BigDecimal("1.35"), 20);
//        Apple apple2 = new Apple(2, "香蕉", new BigDecimal("2.89"), 30);
//        Apple apple3 = new Apple(3, "荔枝", new BigDecimal("9.99"), 40);
//
//        list.add(apple1);
//        list.add(apple12);
//        list.add(apple2);
//        list.add(apple3);
//
//        list.stream().forEach(System.out::println);
//        System.out.println(list.stream().mapToInt(Apple::getNum).sum());
//        System.out.println(list.stream().mapToDouble(Apple::getNum).average().getAsDouble());
//        System.out.println(list.stream().mapToInt(Apple::getNum).max().getAsInt());
//        System.out.println(list.stream().mapToInt(Apple::getNum).min().getAsInt());

//        Map<Integer, Apple> appleMap = list.stream().collect(Collectors.toMap(Apple::getId, a -> a, (k1, k2) -> k1));
//        System.out.println(appleMap);

//        BigDecimal totalMoney = list.stream().map(Apple::getMoney).reduce(BigDecimal.ZERO, BigDecimal::add);
//        System.err.println("totalMoney:" + totalMoney); //totalMoney:17.48
//
////计算 数量
//        Integer sum = list.stream().mapToInt(Apple::getNum).sum();
//        System.err.println("sum:" + sum); //sum:100
//
//        List<Integer> cc = new ArrayList<>();
//        cc.add(1);
//        cc.add(2);
//        cc.add(3);
//        int sum2 = cc.stream().mapToInt(Integer::intValue).sum();//6
//
//        int lengthOfEdu = (int) ChronoUnit.DAYS.between(classPlan.getStartTime().toInstant(), classPlan.getEndTime().toInstant());

        List<String> list = new ArrayList<>();
        for (int i = 0; i < 100000; i++) {
            list.add("item " + i);
        }

        long a = System.currentTimeMillis();
        list.stream().parallel().forEach(System.out::println);

        long b = System.currentTimeMillis();
        list.stream().forEach(System.out::println);

        long c = System.currentTimeMillis();
        list.forEach(System.out::println);
        long d = System.currentTimeMillis();
        System.err.println("***********************************************");
        System.out.println(" 执行耗时 : " + (b - a) / 1000f + " 秒 ");
        System.out.println(" 执行耗时 : " + (c - b) / 1000f + " 秒 ");
        System.out.println(" 执行耗时 : " + (d - c) / 1000f + " 秒 ");
    }
}
