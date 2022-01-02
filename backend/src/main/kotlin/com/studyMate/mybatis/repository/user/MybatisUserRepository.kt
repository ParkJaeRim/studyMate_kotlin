package com.studyMate.mybatis.repository.user

import com.studyMate.domain.user.User
import com.studyMate.domain.user.UserRepository
import com.studyMate.mybatis.mapper.user.UserMapper
import org.springframework.stereotype.Repository

@Repository
class MybatisUserRepository(
    private val userMapper: UserMapper
) : UserRepository {
    override fun findAll(): List<User> = userMapper.findAll().map{ userVo -> userVo.toEntity() }
}
