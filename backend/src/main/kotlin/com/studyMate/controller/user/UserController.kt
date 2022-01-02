package com.studyMate.controller.user

import com.studyMate.mybatis.repository.user.MybatisUserRepository
import com.studyMate.mybatis.values.user.JoinVo
import com.studyMate.mybatis.values.user.LoginVo
import org.springframework.web.bind.annotation.*

@CrossOrigin(origins = ["*"])
@RestController
class UserController(
    private val userRepository: MybatisUserRepository,
    private val kakaoLoginService: KakaoLoginService
) {
    @GetMapping("/kakaologin")
    fun kakaoLogin(@RequestParam("authorize_code") authorizeCode: String, @RequestParam("redirect_name") redirectName: String): HashMap<String, String>? {
        val accessToken: String = kakaoLoginService.getAccessToken(authorizeCode, redirectName)
        return kakaoLoginService.getUserInfo(accessToken)
    }

    @PostMapping("/isExist")
    fun isExist(@RequestBody user: LoginVo): String{
        return if (userRepository.findByEmailAndPassword(user.email, user.password) != null) "success" else "fail"
    }

    @PostMapping("/join")
    fun join(@RequestBody user: JoinVo) {
        userRepository.save(user.toEntity())
    }
}

