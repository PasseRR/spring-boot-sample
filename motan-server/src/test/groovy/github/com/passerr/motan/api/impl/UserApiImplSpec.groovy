package github.com.passerr.motan.api.impl

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer
import github.com.passerr.motan.BaseSpec
import github.com.passerr.motan.api.UserApi
/**
 * @author xiehai1
 * @date 2017/09/01 18:10
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class UserApiImplSpec extends BaseSpec {
    @MotanReferer
    UserApi userApi

    def motan(){
        expect:
        this.userApi != null
    }
}