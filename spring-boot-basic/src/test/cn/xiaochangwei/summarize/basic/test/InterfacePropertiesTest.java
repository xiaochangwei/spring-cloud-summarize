package cn.xiaochangwei.summarize.basic.test;

import cn.xiaochangwei.summarize.basic.utils.InterfaceProperties;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by changw.xiao@qq.com at 2018/12/28 7:56
 **/
@Slf4j
public class InterfacePropertiesTest extends BaseTest {

    @Autowired
    InterfaceProperties interfaceProperties;

    @Test
    public void interfacePropertiesTest() {
        log.info("all " + interfaceProperties.getMyCnblogsArticle001());
        log.info("all " + interfaceProperties.getMyCnblogsArticle002());
        log.info("all " + interfaceProperties.getMyGithubArticle001());
        log.info("all " + interfaceProperties.getMyGithubArticle002());
    }
}
