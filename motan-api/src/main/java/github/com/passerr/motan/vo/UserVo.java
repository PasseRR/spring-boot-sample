package github.com.passerr.motan.vo;

import lombok.Data;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 13:01
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
public class UserVo extends BaseVo{
    private BigInteger userId;
    private String loginId;
    private String userName;
    private String password;
    private String idCardNo;
    private int age;
}
