package cn.xiaochangwei.summarize.basic.test;

import cn.xiaochangwei.summarize.basic.utils.GithubInterfaces;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by changw.xiao@qq.com at 2018/12/28 7:59
 **/
@Slf4j
public class GithubInterfacesTest extends BaseTest {

    @Autowired
    GithubInterfaces githubInterfaces;

    @Test
    public void githubInterfacesTest() {
        log.info("github " + githubInterfaces.getGithubArticle001());
        log.info("github " + githubInterfaces.getGithubArticle002());
    }
}
