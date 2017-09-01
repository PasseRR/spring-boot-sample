package github.com.passerr.motan.api;

import github.com.passerr.motan.vo.ResponseVo;
import github.com.passerr.motan.vo.UserVo;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import java.math.BigInteger;

/**
 * 以Motan方式及Restful方式暴露服务
 * @author xiehai1
 * @date 2017/09/01 15:38
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@Path("/user")
@Produces(MediaType.APPLICATION_JSON)
public interface UserApi {
    @POST
    ResponseVo<BigInteger> addUser(UserVo userVo);

    @PUT
    ResponseVo<Boolean> modifyUser(UserVo userVo);

    @DELETE
    @Path("/{userId}")
    ResponseVo<BigInteger> deleteUser(@PathParam("userId") BigInteger userId);
}