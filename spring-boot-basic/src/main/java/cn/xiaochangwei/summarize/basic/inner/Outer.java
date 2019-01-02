package cn.xiaochangwei.summarize.basic.inner;

import lombok.Data;

import java.util.Random;
import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/12/28 13:04
 **/
@Data
public class Outer {
    private String name = UUID.randomUUID().toString();
    private Integer age = new Random().nextInt(100);

    class Inner {
        private String innerName = "inner_" + name;

        public void print() {
            System.out.println("innerName:" + innerName + ",  outer.name:" + name + ",  out.age:" + age);
        }
    }

    public static void main(String[] args) {
        Outer.Inner inner = new Outer().new Inner();
        inner.print();
    }
}
