package github.com.passerr.motan.config;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.config.RegistryConfig;
import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicServiceConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiehai1
 * @date 2017/09/01 16:36
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
@Setter
public class MotanServerConfig {
    @Bean
    public AnnotationBean annotationBean(AnnotationBeanProperties annotationBeanProperties) {
        return annotationBeanProperties;
    }

    @Bean
    public RegistryConfigBean registryConfig(RegistryConfigProperties registryConfigProperties) {
        if (!"local".equals(registryConfigProperties.getRegProtocol())) {
            MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        }
        return registryConfigProperties;
    }

    @Bean("motan")
    @ConfigurationProperties(prefix = "spring.motan.protocol.motan")
    public ProtocolConfigBean motan() {
        return new ProtocolConfigProperties();
    }

    @Bean("restful")
    @ConfigurationProperties(prefix = "spring.motan.protocol.restful")
    public ProtocolConfigBean restful() {
        ProtocolConfigProperties protocolConfigProperties = new ProtocolConfigProperties();
        protocolConfigProperties.setEndpointFactory("netty");

        return protocolConfigProperties;
    }

    @Bean
    public BasicServiceConfigBean basicServiceConfigBean(
        BasicServiceConfigBeanProperties basicServiceConfigBeanProperties,
        RegistryConfig registryConfig) {
        basicServiceConfigBeanProperties.setRegistry(registryConfig);
        return basicServiceConfigBeanProperties;
    }
}

@Configuration
@ConfigurationProperties(prefix = "spring.motan.annotation")
class AnnotationBeanProperties extends AnnotationBean {

}

@Configuration
@ConfigurationProperties(prefix = "spring.motan.registry")
class RegistryConfigProperties extends RegistryConfigBean {

}

@Configuration
class ProtocolConfigProperties extends ProtocolConfigBean {

}

@Configuration
@ConfigurationProperties(prefix = "spring.motan.basic-service")
class BasicServiceConfigBeanProperties extends BasicServiceConfigBean {

}
