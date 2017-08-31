package github.com.passerr.dubbo.interceptor;

import github.com.passerr.dubbo.exception.DubboException;
import github.com.passerr.dubbo.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;

/**
 * {@link com.alibaba.dubbo.config.annotation.Service}使用代理后有bug<BR/>
 * 使用{@link com.alibaba.dubbo.rpc.Filter}代替{@link github.com.passerr.dubbo.filter.DubboExceptionFilter}
 * @author xiehai1
 * @date 2017/08/31 15:38
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Slf4j
@Deprecated
public class ExceptionInterceptor {
//    @Around("execution(* github.com.passerr.dubbo.api.impl..*(..))")
    public Object intercept(ProceedingJoinPoint proceedingJoinPoint) {
        try {
            return proceedingJoinPoint.proceed();
        } catch (Throwable t) {
            if (t instanceof DubboException) {
                return ResponseVo.fail((DubboException) t);
            }

            log.error(t.getMessage(), t);
            return ResponseVo.fail("99", "系统错误");
        }
    }
}
