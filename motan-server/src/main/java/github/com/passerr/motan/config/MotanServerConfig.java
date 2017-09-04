package github.com.passerr.motan.config;

import com.weibo.api.motan.common.MotanConstants;
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

    @Bean("registry")
    public RegistryConfigBean registryConfig(RegistryConfigProperties registryConfigProperties) {
        if (!"local".equals(registryConfigProperties.getRegProtocol())) {
            MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, true);
        }

        return registryConfigProperties;
    }

    @Bean("motan")
    public ProtocolConfigBean motan() {
        ProtocolConfigBean protocolConfigBean = new ProtocolConfigBean();
        protocolConfigBean.setId("motan");
        protocolConfigBean.setName("motan");

        return protocolConfigBean;
    }

    @Bean("restful")
    public ProtocolConfigBean restful() {
        ProtocolConfigBean protocolConfigBean = new ProtocolConfigBean();
        protocolConfigBean.setId("restful");
        protocolConfigBean.setName("restful");
        protocolConfigBean.setEndpointFactory("netty");

        return protocolConfigBean;
    }

    // 在Service中指定基本配置 否则指定export
    @Bean("basicService")
    public BasicServiceConfigBean basicServiceConfigBean(BasicServiceConfigBeanProperties basicServiceConfigBeanProperties) {
        basicServiceConfigBeanProperties.setRegistry("registry");
        // 默认暴露端口 如果增加或减少 在@MotanService配置
        basicServiceConfigBeanProperties.setExport("restful:8801,motan:8802");

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
@ConfigurationProperties(prefix = "spring.motan.basic-service")
class BasicServiceConfigBeanProperties extends BasicServiceConfigBean {

}
