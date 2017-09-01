package github.com.passerr.dubbo;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiehai1
 * @date 2017/08/31 14:48
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboConsumerApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboConsumerApplication.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(ProtocolConfig::destroyAll));
    }
}
