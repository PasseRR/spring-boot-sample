package github.com.passerr.dubbo.vo;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 13:01
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class UserVo extends BaseVo{
    private BigInteger userId;
    private String loginId;
    private String userName;
    private String password;
    private String idCardNo;
}
