package github.com.passerr.dubbo;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import com.alibaba.dubbo.config.ProtocolConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiehai1
 * @date 2017/08/31 13:12
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@SpringBootApplication
@EnableDubboConfiguration
public class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
        Runtime.getRuntime().addShutdownHook(new Thread(ProtocolConfig::destroyAll));
    }
}
