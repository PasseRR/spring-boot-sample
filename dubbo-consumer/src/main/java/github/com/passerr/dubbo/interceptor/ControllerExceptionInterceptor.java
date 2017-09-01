package github.com.passerr.dubbo.interceptor;

import github.com.passerr.dubbo.exception.DubboException;
import github.com.passerr.dubbo.vo.ResponseVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;

/**
 * @author xiehai1
 * @date 2017/09/01 11:00
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@ControllerAdvice(annotations = {Controller.class, RestController.class})
@Slf4j
public class ControllerExceptionInterceptor extends ExceptionHandlerExceptionResolver{
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseVo handleException(Exception e){
        if(e instanceof DubboException){
            return ResponseVo.fail((DubboException) e);
        }

        log.error(e.getMessage(), e);
        return ResponseVo.fail("98", "系统异常");
    }
}
