package github.com.passerr.dubbo.config;

import com.alibaba.dubbo.config.ProviderConfig;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiehai1
 * @date 2017/08/31 14:14
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
@ConfigurationProperties(prefix = "spring.dubbo")
@Setter
public class DubboConfig {
    private int timeout;
    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
        // 设置provider统一超时
        providerConfig.setTimeout(this.timeout);
//        providerConfig.setFilter();
        return providerConfig;
    }
}
