package com.studyMate.mybatis.values.user

import com.studyMate.domain.user.User
import org.apache.ibatis.type.Alias
import java.time.LocalDateTime

@Alias("user")
data class UserVo(
    var id: Int,
    var realName: String,
    var nickname: String,
    var password: String,
    var email: String,
    var introduction: String?,
    var profileImage: String?,
    var penalty: Integer?,
    var mileage: String?,
    var lastLoginDate: LocalDateTime?,
    var dateCreated: LocalDateTime,
) {
    fun toEntity(): User {
        return User(id, realName, nickname, password, email, introduction, profileImage, penalty, mileage, lastLoginDate, dateCreated)
    }
}

data class LoginVo(
    var email: String,
    var password: String,
)

@Alias("join")
data class JoinVo(
    var realName: String,
    var nickname: String,
    var password: String,
    var email: String,
    var introduction: String,
    var profileImage: String?,
) {
    fun toEntity(): User {
        return User(null, realName, nickname, password, email, introduction, profileImage, null, null, null, null)
    }
}

