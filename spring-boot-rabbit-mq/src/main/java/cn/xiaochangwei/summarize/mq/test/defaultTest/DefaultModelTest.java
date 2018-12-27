package cn.xiaochangwei.summarize.mq.test.defaultTest;

import cn.xiaochangwei.summarize.mq.test.User;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;

import java.io.IOException;

/**
 * create by changw.xiao@qq.com at 2018/12/26 18:14
 * 默认就是direct模式
 **/
@Configuration
public class DefaultModelTest {

    @Bean
    public Queue defaultQue() {
        return new Queue("defaultQue");
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

//    @Scheduled(fixedRate = 1000)
//    public void defaultProducer() {
//        rabbitTemplate.convertAndSend("defaultQue", new User());
//    }

    @RabbitListener(queues = {"defaultQue"})
    public void defaultReceiverObject(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("1:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = {"defaultQue"})
    public void defaultReceiverObject2(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("2:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }
}
