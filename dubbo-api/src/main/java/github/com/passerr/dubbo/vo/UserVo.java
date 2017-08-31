package github.com.passerr.dubbo.vo;

import github.com.passerr.dubbo.api.UserApi;
import lombok.Data;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 13:01
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Data
public class UserVo extends BaseVo{
    // 修改的时候不能为空
    // NotNull修饰Object
    @NotNull(groups = UserApi.ModifyUser.class)
    private BigInteger userId;
    // 添加的时候不能为空
    // NotEmpty修饰String、List、Map
    @NotEmpty(groups = UserApi.AddUser.class)
    private String loginId;
    private String userName;
    private String password;
    @Length(min = 17, max = 17, message = "长度必须为{min}")
    private String idCardNo;
    @Range(min = 18, max = 100)
    private int age;
}
