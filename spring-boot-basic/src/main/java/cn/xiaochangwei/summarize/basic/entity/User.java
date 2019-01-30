package cn.xiaochangwei.summarize.basic.entity;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

/**
 * create by changw.xiao@qq.com at 2018/12/29 9:54
 **/
@Data
public class User implements Serializable {
    private String name = UUID.randomUUID().toString();

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birth = new Date();
}
