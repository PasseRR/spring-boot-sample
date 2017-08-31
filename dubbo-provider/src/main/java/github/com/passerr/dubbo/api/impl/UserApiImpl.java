package github.com.passerr.dubbo.api.impl;

import com.alibaba.dubbo.config.annotation.Service;
import github.com.passerr.dubbo.api.UserApi;
import github.com.passerr.dubbo.exception.DubboException;
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
@Service(interfaceClass = UserApi.class)
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
        if(new BigInteger("1").compareTo(userId) == 0){
            throw new DubboException("02", "超级用户不能删除!");
        }

        return ResponseVo.ok(userId);
    }
}
