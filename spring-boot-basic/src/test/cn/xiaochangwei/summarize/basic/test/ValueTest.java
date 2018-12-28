package cn.xiaochangwei.summarize.basic.test;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Value;

/**
 * create by changw.xiao@qq.com at 2018/12/28 12:46
 **/
@Slf4j
public class ValueTest extends BaseTest {

    @Value("${interfaces.cnblogs.root}")
    private String cnblogsRoot;

    @Value("${interfaces.cnblogs.root2:this is the default value}")
    private String ifNotConfigUseDefaultValue;

    @Test
    public void ValueTest() {
        log.info("cnblogsRoot:" + cnblogsRoot);
        log.info("ifNotConfigUseDefaultValue:" + ifNotConfigUseDefaultValue);
    }
}
