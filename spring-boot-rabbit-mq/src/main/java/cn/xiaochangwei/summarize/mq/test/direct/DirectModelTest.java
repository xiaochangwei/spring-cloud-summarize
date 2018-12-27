package cn.xiaochangwei.summarize.mq.test.direct;

import cn.xiaochangwei.summarize.common.exception.BusinessException;
import cn.xiaochangwei.summarize.mq.test.User;
import com.alibaba.fastjson.JSON;
import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
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
import java.util.Random;

/**
 * create by changw.xiao@qq.com at 2018/12/26 19:00
 **/
@Configuration
public class DirectModelTest {

    @Bean
    public Queue directQueue1() {
        return new Queue("directQueue1");
    }

    @Bean
    public Queue directQueue2() {
        return new Queue("directQueue2");
    }

    @Bean
    public DirectExchange directExchange() {
        return new DirectExchange("directExchange");
    }

    @Bean
    Binding bindingDirectQueue1ToDirectExchange(Queue directQueue1, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue1).to(directExchange).with("d1");
    }

    @Bean
    Binding bindingDirectQueue2ToDirectExchange(Queue directQueue2, DirectExchange directExchange) {
        return BindingBuilder.bind(directQueue2).to(directExchange).with("d2");
    }


    @Autowired
    RabbitTemplate rabbitTemplate;

//    @Scheduled(fixedRate = 1000)
//    public void directProducer() {
//        rabbitTemplate.convertAndSend("directExchange", "d1", new User("d1"));
//        rabbitTemplate.convertAndSend("directExchange", "d2", new User("d2"));
//        rabbitTemplate.convertAndSend("directExchange", "d3", new User("d3"));
//    }

    @RabbitListener(queues = {"directQueue1"})
    public void directQueue1Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("directQueue1:" + JSON.toJSONString(user));
        Random random = new Random();
        if (random.nextInt(2) == 0) {
            throw new BusinessException("0000000000000000000000000");
        }
        channel.basicAck(deliveryTag, false);
    }

    @RabbitListener(queues = {"directQueue2"})
    public void directQueue2Receiver(Channel channel, @Header(AmqpHeaders.DELIVERY_TAG) long deliveryTag, @Payload User user) throws IOException {
        System.out.println("directQueue2:" + JSON.toJSONString(user));
        channel.basicAck(deliveryTag, false);
    }

}
