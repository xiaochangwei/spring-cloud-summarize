package cn.xiaochangwei.summarize.basic.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * create by changw.xiao@qq.com at 2018/12/28 7:49
 **/
@Data
@Component
@ConfigurationProperties(prefix = "interfaces.github")
public class GithubInterfaces {
    private String githubArticle001;
    private String githubArticle002;
}
