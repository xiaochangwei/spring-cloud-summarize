package cn.xiaochangwei.summarize.basic.remove;

import java.util.*;

/**
 * create by changw.xiao@qq.com at 2018/12/29 9:34
 **/
public class Remove {
    public static void main(String[] args) {
//        Map<String, String> source = new HashMap<String, String>();
//        for (int i = 0; i < 10; i++) {
//            source.put("key" + i, "value" + i);
//        }
//        System.out.println("Source:" + source);
//        fastFailSceneWhenRemove(source);
////        commonSceneWhenRemove(source);

//        ArrayList<String> list = new ArrayList<String>(Arrays.asList("a", "b", "c", "d"));
//        for (int i = 0; i < list.size(); i++) {
//            System.out.println(list.size() + ",delete:" + list.get(i));
//            list.remove(i);
//        }
//        System.out.println(list);

        ArrayList<String> list = new ArrayList<>(Arrays.asList("a", "b", "c", "d"));
        ArrayList<String> list2 = new ArrayList<>(list);
        for (String s : list2) {
            if("b".equals(s)){
                s = "bb";
            }
        }

        System.out.println(list);
        System.out.println(list2);

    }

    private static void commonSceneWhenRemove(Map<String, String> source) {
        Iterator<Map.Entry<String, String>> iterator = source.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, String> entry = iterator.next();
            if (entry.getKey().contains("1")) {
                iterator.remove();
            }
        }
        System.out.println(source);
    }

    private static void fastFailSceneWhenRemove(Map<String, String> source) {
        for (Map.Entry<String, String> entry : source.entrySet()) {
            if (entry.getKey().contains("1")) {
                source.remove(entry.getKey());
            }
        }
        System.out.println(source);
    }
}
