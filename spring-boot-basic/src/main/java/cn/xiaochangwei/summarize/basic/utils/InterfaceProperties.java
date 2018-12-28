package cn.xiaochangwei.summarize.basic.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by changw.xiao@qq.com at 2018/12/28 7:45
 **/
@Data
@Component
@ConfigurationProperties(prefix = "interfaces")
public class InterfaceProperties {
    private String myCnblogsArticle001;
    private String myCnblogsArticle002;
    private String myGithubArticle001;
    private String myGithubArticle002;
}
