package github.com.passerr.motan.api.impl

import com.weibo.api.motan.config.springsupport.annotation.MotanReferer
import github.com.passerr.motan.BaseSpec
import github.com.passerr.motan.api.UserApi
import github.com.passerr.motan.vo.UserVo

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

    def add(){
        given:
        def user = new UserVo(loginId: 1)

        when:
        def response = this.userApi.addUser(user)
        then:
        response.isOk()
        response.getData() == 1
    }

    def modify(){
        given:
        def user = new UserVo(userId: 1)

        when:
        def response = this.userApi.modifyUser(user)
        then:
        response.isOk()
        response.getData()
    }

    def delete(){
        when:
        def response = this.userApi.deleteUser(2)
        then:
        response.isOk()
        response.getData() == 2
    }
}