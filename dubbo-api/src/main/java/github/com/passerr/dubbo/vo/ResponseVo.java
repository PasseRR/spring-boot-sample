package github.com.passerr.dubbo.vo;

import lombok.Builder;
import lombok.Getter;

/**
 * @author xiehai1
 * @date 2017/08/31 13:03
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Builder
@Getter
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
}
