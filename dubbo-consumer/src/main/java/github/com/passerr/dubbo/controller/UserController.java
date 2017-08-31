package github.com.passerr.dubbo.controller;

import com.alibaba.boot.dubbo.annotation.DubboConsumer;
import github.com.passerr.dubbo.api.UserApi;
import github.com.passerr.dubbo.vo.ResponseVo;
import github.com.passerr.dubbo.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/08/31 14:56
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @DubboConsumer
    private UserApi userApi;

    @PostMapping
    public ResponseVo<BigInteger> addUser(@RequestBody UserVo userVo){
        return this.userApi.addUser(userVo);
    }

    @PutMapping
    public ResponseVo<Boolean> modifyUser(@RequestBody UserVo userVo){
        return this.userApi.modifyUser(userVo);
    }

    @DeleteMapping("/{userId}")
    public ResponseVo<BigInteger> deleteUser(@PathVariable("userId") BigInteger userId){
        return this.userApi.deleteUser(userId);
    }
}
