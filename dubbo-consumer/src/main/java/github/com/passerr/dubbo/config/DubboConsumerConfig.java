package github.com.passerr.dubbo.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiehai1
 * @date 2017/08/31 14:56
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
public class DubboConsumerConfig {
    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
        // 启动不校验消费者
        consumerConfig.setCheck(false);

        return consumerConfig;
    }
}
