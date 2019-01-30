package cn.xiaochangwei.summarize.basic.remove;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class OOMTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        while (true) {
            list.add(new Random().nextInt(1000));
            if (list.size() == 5000) {
                list.clear();
            }
        }
    }
}
