package cn.xiaochangwei.summarize.mq.test;

import cn.xiaochangwei.summarize.common.utils.DateUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/12/26 18:18
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private String userName = UUID.randomUUID().toString().replaceAll("-", "");
    private String time = DateUtil.formatDate(new Date());
    private String flag;

    public User(String flag) {
        this.flag = flag;
    }
}
