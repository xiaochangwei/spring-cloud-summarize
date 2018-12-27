import cn.xiaochangwei.summarize.mq.test.topic.TopicModelTest;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * create by changw.xiao@qq.com at 2018/12/27 10:42
 **/
public class MQTest extends BaseTest {

    @Autowired
    TopicModelTest topicModelTest;

    @Test
    public void test1() {
        topicModelTest.topicMessageSender("a.b.d");
    }
}
