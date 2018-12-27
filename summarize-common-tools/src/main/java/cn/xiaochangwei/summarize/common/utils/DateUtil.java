package cn.xiaochangwei.summarize.common.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * create by changw.xiao@qq.com at 2018/10/16 11:41
 **/
public class DateUtil {
    public static final String DATE_FORMART_PATTERN = "yyyy-MM-dd HH:mm:ss";

    public static String getMonth(Date date, Integer increaseOrDecrease) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, increaseOrDecrease);
        return calendar.get(Calendar.YEAR) + "_" + (calendar.get(Calendar.MONTH) + 1);
    }

    public static String formatDate(Date date) {
        return formatDate(date, DATE_FORMART_PATTERN);
    }

    public static String formatDate(Date date, String pattern) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        return simpleDateFormat.format(date);
    }

}
