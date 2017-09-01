package github.com.passerr.dubbo.config;

import com.alibaba.dubbo.config.ConsumerConfig;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiehai1
 * @date 2017/08/31 14:56
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
@ConfigurationProperties(prefix = "spring.dubbo.shutdown")
@Setter
public class DubboConsumerConfig {
    private String timeout;
    @Bean
    public ConsumerConfig consumerConfig(){
        ConsumerConfig consumerConfig = new ConsumerConfig();
        // 启动不校验消费者
        consumerConfig.setCheck(false);
        // 优雅停机超时时间
        Map<String, String> parameters = new HashMap<>();
        parameters.put("shutdown.timeout", this.timeout);
        consumerConfig.setParameters(parameters);

        return consumerConfig;
    }
}
