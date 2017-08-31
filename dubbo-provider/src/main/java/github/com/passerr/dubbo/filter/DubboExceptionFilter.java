package github.com.passerr.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import github.com.passerr.dubbo.exception.DubboException;
import github.com.passerr.dubbo.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;

/**
 * dubbo api异常过滤器<BR>
 * order为-1保证其比order为0的filter先执行<BR>
 * 主要保证比{@link com.alibaba.dubbo.rpc.filter.ExceptionFilter}先执行 并过滤掉异常
 * @author xiehai1
 * @date 2017/08/31 16:10
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Activate(group = Constants.PROVIDER, order = -1)
@Slf4j
public class DubboExceptionFilter implements Filter {
    @Override
    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Result result = invoker.invoke(invocation);
            if (result.hasException()) {
                // 如果是业务异常 直接抛出
                if (result.getException() instanceof DubboException) {
                    log.debug(result.getException().getMessage(), result.getException());
                    throw (DubboException) result.getException();
                } else { // 非业务异常转为业务异常抛出
                    log.error(result.getException().getMessage(), result.getException());
                    throw new DubboException("99", "系统错误");
                }
            }

            return result;
        } catch (Exception e) {
            if (e instanceof DubboException) {
                return new RpcResult(ResponseVo.fail((DubboException) e));
            }

            log.error(e.getMessage(), e);
            return new RpcResult(ResponseVo.fail("99", "系统错误"));
        }
    }
}
