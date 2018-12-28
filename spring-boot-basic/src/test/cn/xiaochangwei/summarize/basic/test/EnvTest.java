package cn.xiaochangwei.summarize.basic.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;

/**
 * create by changw.xiao@qq.com at 2018/12/28 12:46
 **/
@Slf4j
public class EnvTest extends BaseTest {

    @Autowired
    Environment environment;

    @Test
    public void EnvTest() {
        log.info("cnblogsRoot:" + environment.getProperty("interfaces.cnblogs.root"));
        log.info("notExistPropertie:" + environment.getProperty("notExistPropertie"));
    }
}
