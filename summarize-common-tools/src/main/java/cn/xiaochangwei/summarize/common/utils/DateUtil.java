package cn.xiaochangwei.summarize.common.utils;

import java.util.Calendar;
import java.util.Date;

/**
 * create by changw.xiao@qq.com at 2018/10/16 11:41
 **/
public class DateUtil {
    public static String getMonth(Date date, Integer increaseOrDecrease) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, increaseOrDecrease);
        return calendar.get(Calendar.YEAR) + "_" + (calendar.get(Calendar.MONTH) + 1);
    }
}
