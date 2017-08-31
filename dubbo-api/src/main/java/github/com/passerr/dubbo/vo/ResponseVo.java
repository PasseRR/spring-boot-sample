package github.com.passerr.dubbo.vo;

import github.com.passerr.dubbo.exception.DubboException;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

/**
 * @author xiehai1
 * @date 2017/08/31 13:03
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Builder
@Getter
@ToString
public class ResponseVo<T> extends BaseVo {
    private boolean isOk;
    private String responseCode;
    private String responseMessage;
    private T data;

    public static <T> ResponseVo<T> ok(T data){
        return ResponseVo.<T>builder()
            .isOk(true)
            .responseCode("00")
            .data(data)
            .build();
    }

    public static ResponseVo fail(String responseCode, String responseMessage){
        return ResponseVo.builder()
            .isOk(false)
            .responseCode(responseCode)
            .responseMessage(responseMessage)
            .build();
    }

    public static ResponseVo fail(DubboException exception){
        return ResponseVo.builder()
            .isOk(false)
            .responseCode(exception.getCode())
            .responseMessage(exception.getMessage())
            .build();
    }
}
