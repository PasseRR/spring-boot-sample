package github.com.passerr.motan

import org.slf4j.LoggerFactory
import org.springframework.boot.test.context.ConfigFileApplicationContextInitializer
import org.springframework.test.context.ContextConfiguration
import org.springframework.test.context.web.WebAppConfiguration
import spock.lang.Specification


/**
 * @author xiehai1
 * @date 2017/09/01 18:09
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
@WebAppConfiguration
@ContextConfiguration(classes = MotanServerApplication.class, initializers = ConfigFileApplicationContextInitializer.class)
class BaseSpec extends Specification {
    def logger = LoggerFactory.getLogger(BaseSpec.class)
}