package com.studyMate.mybatis.values.user

import com.studyMate.domain.user.User
import org.apache.ibatis.type.Alias
import java.time.LocalDateTime

@Alias("user")
data class UserVo(
    var id: Int,
    var realName: String,
    var nickName: String,
    var password: String,
    var email: String,
    var introduction: String,
    var profileImage: String,
    var penalty: Integer,
    var mileage: String,
    var lastLoginDate: LocalDateTime,
    var dateCreated: LocalDateTime,
) {
    fun toEntity(): User {
        return User(id, realName, nickName, password, email, introduction, profileImage, penalty, mileage, lastLoginDate, dateCreated)
    }
}
