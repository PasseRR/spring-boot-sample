package github.com.passerr.dubbo.api.impl

import com.alibaba.boot.dubbo.annotation.DubboConsumer
import github.com.passerr.dubbo.BaseSpec
import github.com.passerr.dubbo.api.UserApi
/**
 * @author xiehai1
 * @date 2017/08/31 15:47
 * @Copyright ( c ) gome inc Gome Co.,LTD
 */
class UserApiImplSpec extends BaseSpec {
    @DubboConsumer
    UserApi userApi

    def dubbo(){
        expect:
        this.userApi != null
    }

    def delete(){
        given:
        def response

        when:
        response = this.userApi.deleteUser(2)
        then:
        response.isOk()
        response.responseCode == "00"

        when:
        response = this.userApi.deleteUser(1)
        then:
        !response.isOk()
        response.responseCode == "01"
        response.responseMessage == "超级用户不能删除!"
    }
}