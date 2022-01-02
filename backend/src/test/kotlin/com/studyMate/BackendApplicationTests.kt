package com.studyMate

import com.studyMate.controller.user.UserController
import com.studyMate.mybatis.values.user.LoginVo
import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class BackendApplicationTests {

    @Autowired
    lateinit var userController: UserController

    @Test
    @DisplayName("이메일과 비밀번호가 맞을경우만 로그인에 성공한다.")
    fun loginSuccessTest() {
        val successUser = LoginVo("jaerim@kakao.com", "qwer1234")
        Assertions.assertEquals(userController.isExist(successUser), "success")
    }

    @Test
    @DisplayName("이메일과 비밀번호가 하나라도 틀릴경우 로그인에 실패한다.")
    fun loginFailTest() {
        val diffPasswordUser = LoginVo("jaerim@kakao.com", "fpokjlajf")
        val diffEmailUser = LoginVo("unknown@kakao.com", "qwer1234")
        val diffAllUser = LoginVo("unknown@kakao.com", "fpokjlajf")
        Assertions.assertEquals(userController.isExist(diffPasswordUser), "fail")
        Assertions.assertEquals(userController.isExist(diffEmailUser), "fail")
        Assertions.assertEquals(userController.isExist(diffAllUser), "fail")
    }
}
