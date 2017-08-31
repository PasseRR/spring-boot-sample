package github.com.passerr.dubbo

import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification
/**
 * @author xiehai1
 * @date 2017/08/31 15:45
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
@WebAppConfiguration
@ContextConfiguration(classes = DubboProviderApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
class BaseSpec extends Specification {
    def logger = LoggerFactory.getLogger(BaseSpec.class)
}