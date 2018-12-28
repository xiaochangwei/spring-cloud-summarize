package cn.xiaochangwei.summarize.basic.test;

import cn.xiaochangwei.summarize.basic.utils.CnblogsInterfaces;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by changw.xiao@qq.com at 2018/12/28 7:59
 **/
@Slf4j
public class CnblogsInterfacesTest extends BaseTest {

    @Autowired
    CnblogsInterfaces cnblogsInterfaces;

    @Test
    public void cnblogsInterfacesTest() {
        log.info("cnblogs " + cnblogsInterfaces.getCnblogsArticle001());
        log.info("cnblogs " + cnblogsInterfaces.getCnblogsArticle002());
    }
}
