import cn.xiaochangwei.summarize.single.SigleDataSourceApplication;
import cn.xiaochangwei.summarize.single.dao.repo.CommentsRepository;
import cn.xiaochangwei.summarize.single.entity.Comments;
import com.netflix.discovery.converters.Auto;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.junit.Test;

import java.util.Random;
import java.util.UUID;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SigleDataSourceApplication.class)
public class UnitTest {

    @Autowired
    CommentsRepository commentsRepository;

    @Test
    public void createData() {
        int i = 0;
        while (i < 300000) {
            commentsRepository.saveAndFlush(new Comments(new Random().nextInt(10000),new Random().nextInt(1000), new Random().nextInt(2), UUID.randomUUID().toString()));
            i++;
        }
    }
}
