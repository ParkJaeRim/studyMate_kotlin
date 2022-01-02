package com.studyMate.controller.user

import com.studyMate.mybatis.repository.study.MybatisStudyRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
class UserController(
    private val studyRepository: MybatisStudyRepository,
    private val kakaoLoginService: KakaoLoginService
) {
    @GetMapping("/kakaologin")
    fun kakaoLogin(@RequestParam("authorize_code") authorizeCode: String): HashMap<String, String> {
        val accessToken: String = kakaoLoginService.getAccessToken(authorizeCode)
        val userInfo: HashMap<String, String>? = kakaoLoginService.getUserInfo(accessToken)
        print(userInfo!!["email"])
        print(userInfo!!["id"])

        // email과 id가 DB에 있는지
        if(){

        }
        return userInfo
    }
}

