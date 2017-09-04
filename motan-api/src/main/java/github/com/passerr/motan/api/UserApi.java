package github.com.passerr.motan.api;

import github.com.passerr.motan.vo.ResponseVo;
import github.com.passerr.motan.vo.UserVo;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/09/01 15:38
 * @Copyright(c) gome inc Gome Co.,LTD
 */
public interface UserApi {
    ResponseVo<UserVo> getUser(BigInteger userId);

    ResponseVo<BigInteger> addUser(UserVo userVo);

    ResponseVo<Boolean> modifyUser(UserVo userVo);

    ResponseVo<BigInteger> deleteUser(BigInteger userId);
}