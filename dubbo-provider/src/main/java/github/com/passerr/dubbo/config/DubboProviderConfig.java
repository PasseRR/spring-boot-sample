package github.com.passerr.dubbo.config;

import com.alibaba.dubbo.config.ProviderConfig;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiehai1
 * @date 2017/08/31 14:14
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
@ConfigurationProperties(prefix = "spring.dubbo")
@Setter
public class DubboProviderConfig {
    private int timeout;
    @Getter
    private Map<String, Object> shutdown;
    @Bean
    public ProviderConfig providerConfig(){
        ProviderConfig providerConfig = new ProviderConfig();
        // 设置provider统一超时
        providerConfig.setTimeout(this.timeout);
        // Spring容器初始化完后再暴露服务
        providerConfig.setDelay(-1);
        /**
         * 设置参数校验、异常处理filter
         * @see github.com.passerr.dubbo.filter.ValidationFilter
         * @see github.com.passerr.dubbo.filter.DubboExceptionFilter
         */
        providerConfig.setFilter("validationFilter,exceptionFilter");
        // 优雅停机超时时间
        Map<String, String> parameters = new HashMap<>();
        parameters.put("shutdown.timeout", String.valueOf(this.shutdown.get("timeout")));
        providerConfig.setParameters(parameters);

        return providerConfig;
    }
}
