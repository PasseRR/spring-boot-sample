package github.com.passerr.motan.api.impl;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import github.com.passerr.motan.api.UserApi;
import github.com.passerr.motan.vo.ResponseVo;
import github.com.passerr.motan.vo.UserVo;
import org.springframework.stereotype.Component;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 13:55
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Component
@MotanService(interfaceClass = UserApi.class, export = "motan:8801,restful:8802")
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
