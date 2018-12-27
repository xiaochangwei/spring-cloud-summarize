package cn.xiaochangwei.summarize.mq.test.topic;

import cn.xiaochangwei.summarize.common.utils.DateUtil;
import cn.xiaochangwei.summarize.common.vo.Result;
import cn.xiaochangwei.summarize.mq.test.User;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Date;

/**
 * create by changw.xiao@qq.com at 2018/12/26 19:00
 **/
@Configuration
@RestController
public class TopicModelTest {

    @Bean
    public Queue topicQueue1() {
        return new Queue("topicQueue1");
    }

    @Bean
    public Queue topicQueue2() {
        return new Queue("topicQueue2");
    }

    @Bean
    public Queue topicQueue3() {
        return new Queue("topicQueue3");
    }

    @Bean
    public TopicExchange topicExchange() {
        return new TopicExchange("topicExchange");
    }


    @Bean
    Binding bindingTopicQueue1ToTopicExchange(Queue topicQueue1, TopicExchange topicExchange) {
        //修改了routingKey后，启动时会自动绑定，但是之前的绑定不会被删除，同时存在
        return BindingBuilder.bind(topicQueue1).to(topicExchange).with("a.*");
    }

    @Bean
    Binding bindingTopicQueue2ToTopicExchange(Queue topicQueue2, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue2).to(topicExchange).with("*.b.*");
    }

    @Bean
    Binding bindingTopicQueue3ToTopicExchange(Queue topicQueue3, TopicExchange topicExchange) {
        return BindingBuilder.bind(topicQueue3).to(topicExchange).with("#.c");
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = {"topicQueue1"})
    public void topicQueue1Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("topicQueue1:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = {"topicQueue2"})
    public void topicQueue2Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("topicQueue2:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = {"topicQueue3"})
    public void topicQueue3Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("topicQueue3:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

    @GetMapping("/topic/sender")
    public Result topicMessageSender(@RequestParam("topic") String topic) {
        rabbitTemplate.convertAndSend("topicExchange", topic, new User());
        return Result.success(DateUtil.formatDate(new Date()));
    }

}
