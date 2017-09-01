package github.com.passerr.motan;

import com.weibo.api.motan.common.MotanConstants;
import com.weibo.api.motan.util.MotanSwitcherUtil;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author xiehai1
 * @date 2017/09/01 16:33
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@SpringBootApplication
public class MotanServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(MotanServerApplication.class, args);
        Runtime.getRuntime()
            // 优雅停机
            .addShutdownHook(new Thread(() -> MotanSwitcherUtil.setSwitcherValue(MotanConstants.REGISTRY_HEARTBEAT_SWITCHER, false)));
    }
}
