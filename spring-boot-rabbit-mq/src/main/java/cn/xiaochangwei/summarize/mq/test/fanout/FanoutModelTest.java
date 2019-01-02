package cn.xiaochangwei.summarize.mq.test.fanout;

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

import java.io.IOException;

/**
 * create by changw.xiao@qq.com at 2018/12/26 19:00
 **/
@Configuration
public class FanoutModelTest {

    @Bean
    public Queue fanoutQueue1() {
        return new Queue("fanoutQueue1");
    }

    @Bean
    public Queue fanoutQueue2() {
        return new Queue("fanoutQueue2");
    }

    @Bean
    public FanoutExchange fanoutExchange() {
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    Binding bindingFanoutQueue1ToFanoutExchange(Queue fanoutQueue1, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue1).to(fanoutExchange);
    }

    @Bean
    Binding bindingFanoutQueue2ToFanoutExchange(Queue fanoutQueue2, FanoutExchange fanoutExchange) {
        return BindingBuilder.bind(fanoutQueue2).to(fanoutExchange);
    }

    @Autowired
    RabbitTemplate rabbitTemplate;

    @Scheduled(fixedRate = 1000)
    public void directProducer() {
        rabbitTemplate.convertAndSend("fanoutExchange", "", new User("fanout"));
    }

    @RabbitListener(queues = {"fanoutQueue1"})
    public void fanoutQueue1Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("fanoutQueue1:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = {"fanoutQueue2"})
    public void fanoutQueue2Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("fanoutQueue2:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

}
