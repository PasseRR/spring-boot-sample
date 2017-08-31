package github.com.passerr.dubbo.filter;

import com.alibaba.dubbo.common.Constants;
import com.alibaba.dubbo.common.extension.Activate;
import com.alibaba.dubbo.rpc.*;
import com.alibaba.dubbo.validation.Validation;
import com.alibaba.dubbo.validation.Validator;
import github.com.passerr.dubbo.vo.ResponseVo;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.Iterator;
import java.util.Set;

/**
 * 参数校验filter
 * @author xiehai1
 * @date 2017/08/31 16:55
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Slf4j
@Activate(group = Constants.PROVIDER, order = -10)
public class ValidationFilter implements Filter {
    @Setter
    private Validation validation;

    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
        try {
            Validator validator = validation.getValidator(invoker.getUrl());
            if (validator != null) {
                validator.validate(invocation.getMethodName(), invocation.getParameterTypes(), invocation.getArguments());
            }
        } catch (Exception e) {
            if (e instanceof ConstraintViolationException) {
                ConstraintViolationException constraintViolationException = (ConstraintViolationException) e;
                Set<ConstraintViolation<?>> constraintViolations = constraintViolationException.getConstraintViolations();
                Iterator<ConstraintViolation<?>> iterator = constraintViolations.iterator();
                StringBuilder sb = new StringBuilder();
                int size = constraintViolations.size();
                int index = 1;
                while (iterator.hasNext()) {
                    ConstraintViolation<?> constraintViolation = iterator.next();
                    if (size != 1) {
                        sb.append(index++);
                        sb.append(".");
                    }
                    sb.append(constraintViolation.getPropertyPath());
                    sb.append(constraintViolation.getMessage());
                    sb.append(";");
                }

                return new RpcResult(ResponseVo.fail("01", sb.toString()));
            }

            log.error(e.getMessage(), e);
            return new RpcResult(ResponseVo.fail("99", "系统错误"));
        }
        return invoker.invoke(invocation);
    }
}
