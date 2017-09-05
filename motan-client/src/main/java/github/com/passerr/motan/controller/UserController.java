package github.com.passerr.motan.controller;

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer;
import github.com.passerr.motan.api.UserApi;
import github.com.passerr.motan.vo.ResponseVo;
import github.com.passerr.motan.vo.UserVo;
import org.springframework.web.bind.annotation.*;

import java.math.BigInteger;

/**
 * @author xiehai1
 * @date 2017/09/05 10:20
 * @Copyright(c) gome inc Gome Co.,LTD
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @MotanReferer(basicReferer = "basicReferer")
    private UserApi userApi;

    @GetMapping("/{userId}")
    public ResponseVo<UserVo> getUser(@PathVariable("userId") BigInteger userId){
        return this.userApi.getUser(userId);
    }

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
