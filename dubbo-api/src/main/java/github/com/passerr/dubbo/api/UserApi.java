package github.com.passerr.dubbo.api;

import github.com.passerr.dubbo.vo.ResponseVo;
import github.com.passerr.dubbo.vo.UserVo;

import javax.validation.constraints.NotNull;
import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 13:00
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface UserApi {
    @interface AddUser{}
    ResponseVo<BigInteger> addUser(UserVo userVo);

    @interface ModifyUser{}
    ResponseVo<Boolean> modifyUser(UserVo userVo);

    ResponseVo<BigInteger> deleteUser(@NotNull BigInteger userId);
}