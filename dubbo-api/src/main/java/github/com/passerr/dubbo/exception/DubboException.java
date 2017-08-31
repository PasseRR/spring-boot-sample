package github.com.passerr.dubbo.exception;

import lombok.Getter;

/**
 * @author xiehai1
 * @date 2017/08/31 15:41
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Getter
public class DubboException extends RuntimeException {
    private String code;
    private String message;

    public DubboException(String code, String message) {
        super(message);
        this.code = code;
        this.message = message;
    }
}
