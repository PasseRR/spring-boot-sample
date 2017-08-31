package github.com.passerr.dubbo;

import com.alibaba.boot.dubbo.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiehai1
 * @date 2017/08/31 13:12
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@SpringBootApplication
@EnableDubboConfiguration
class DubboProviderApplication {
    public static void main(String[] args) {
        SpringApplication.run(DubboProviderApplication.class, args);
    }
}
