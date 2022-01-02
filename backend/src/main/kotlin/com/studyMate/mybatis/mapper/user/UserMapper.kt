package com.studyMate.mybatis.mapper.user

import com.studyMate.domain.user.User
import com.studyMate.mybatis.values.user.UserVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun findByEmail(email: String): UserVo?
    fun findByEmailAndPassword(email: String, password: String): UserVo?
    fun save(user: User)
}
