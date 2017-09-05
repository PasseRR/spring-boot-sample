package github.com.passerr.motan.config;

import com.weibo.api.motan.config.springsupport.AnnotationBean;
import com.weibo.api.motan.config.springsupport.BasicRefererConfigBean;
import com.weibo.api.motan.config.springsupport.ProtocolConfigBean;
import com.weibo.api.motan.config.springsupport.RegistryConfigBean;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author xiehai1
 * @date 2017/09/05 10:21
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Configuration
public class MotanClientConfig {
    @Bean
    public AnnotationBean annotationBean(AnnotationBeanProperties annotationBeanProperties){
        return annotationBeanProperties;
    }

    @Bean("registry")
    public RegistryConfigBean registryConfigBean(RegistryConfigProperties registryConfigProperties){
        return registryConfigProperties;
    }

    @Bean("motan")
    public ProtocolConfigBean protocolConfigBean(){
        ProtocolConfigBean protocolConfigBean = new ProtocolConfigBean();
        protocolConfigBean.setName("motan");
        protocolConfigBean.setHaStrategy("failover");
        protocolConfigBean.setLoadbalance("roundrobin");
        protocolConfigBean.setMaxClientConnection(10);
        protocolConfigBean.setMinClientConnection(2);
        protocolConfigBean.setDefault(true);

        return protocolConfigBean;
    }

    @Bean("basicReferer")
    public BasicRefererConfigBean basicRefererConfigBean(BasicRefererConfigBeanProperties basicRefererConfigBeanProperties){
        basicRefererConfigBeanProperties.setProtocol("motan");
        basicRefererConfigBeanProperties.setRegistry("registry");
        return basicRefererConfigBeanProperties;
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
@ConfigurationProperties(prefix = "spring.motan.basic-referer")
class BasicRefererConfigBeanProperties extends BasicRefererConfigBean{

}
