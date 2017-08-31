package github.com.passerr.dubbo.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import github.com.passerr.dubbo.api.UserApi;
import github.com.passerr.dubbo.vo.ResponseVo;
import github.com.passerr.dubbo.vo.UserVo;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 13:55
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Component
@Service(interfaceClass = UserApi.class, timeout = 10000)
public class UserApiImpl implements UserApi {
    @Override
    public ResponseVo<BigInteger> addUser(UserVo userVo) {
        return ResponseVo.ok(new BigInteger("1"));
    }

    @Override
    public ResponseVo<Boolean> modifyUser(UserVo userVo) {
        return ResponseVo.ok(Boolean.TRUE);
    }

    @Override
    public ResponseVo<BigInteger> deleteUser(BigInteger userId) {
        return ResponseVo.ok(userId);
    }
}
