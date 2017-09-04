package github.com.passerr.motan.api.impl;

import com.weibo.api.motan.config.springsupport.annotation.MotanService;
import github.com.passerr.motan.api.UserApi;
import github.com.passerr.motan.vo.ResponseVo;
import github.com.passerr.motan.vo.UserVo;
import org.springframework.stereotype.Component;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;

/**
 * 以Motan方式及Restful方式暴露服务
 * @author xiehai1
 * @date 2017/08/31 13:55
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Component
@MotanService(interfaceClass = UserApi.class, export = "motan:8801,restful:8802")
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public class UserApiImpl implements UserApi {
    @POST
    @Override
    public ResponseVo<BigInteger> addUser(UserVo userVo) {
        return ResponseVo.ok(new BigInteger("1"));
    }

    @PUT
    @Override
    public ResponseVo<Boolean> modifyUser(UserVo userVo) {
        return ResponseVo.ok(Boolean.TRUE);
    }

    @DELETE
    @Path("/{userId}")
    @Override
    public ResponseVo<BigInteger> deleteUser(@PathParam("userId") BigInteger userId) {
        return ResponseVo.ok(userId);
    }
}
