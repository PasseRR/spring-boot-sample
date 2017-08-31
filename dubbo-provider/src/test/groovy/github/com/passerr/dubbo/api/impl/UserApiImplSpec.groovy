package github.com.passerr.dubbo.api.impl

import com.alibaba.boot.dubbo.annotation.DubboConsumer
import github.com.passerr.dubbo.BaseSpec
import github.com.passerr.dubbo.api.UserApi
import github.com.passerr.dubbo.vo.UserVo

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

    def add(){
        given:
        def userVo = new UserVo(
            loginId: "",
            userName: "2",
            password: "123456",
            idCardNo: "5112319870627097x",
            age: 19
        )

        when:
        def response = this.userApi.addUser(userVo)
        logger.debug(response.toString())
        then:
        notThrown(Exception.class)
        !response.isOk()
        response.getResponseCode() == "01"
    }

    def modify(){
        given:
        def userVo = new UserVo(
            loginId: "",
            userName: "2",
            password: "123456",
            idCardNo: "5112319870627097x",
            age: 19
        )

        when:
        def response = this.userApi.modifyUser(userVo)
        logger.debug(response.toString())
        then:
        !response.isOk()
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
        response.responseCode == "02"
        response.responseMessage == "超级用户不能删除!"

        when:
        response = this.userApi.deleteUser(null)
        println response
        then:
        !response.isOk()
    }
}