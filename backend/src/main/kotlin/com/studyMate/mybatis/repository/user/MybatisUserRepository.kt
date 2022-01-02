package com.studyMate.mybatis.repository.user

import com.studyMate.domain.user.User
import com.studyMate.domain.user.UserRepository
import com.studyMate.mybatis.mapper.user.UserMapper
import org.springframework.stereotype.Repository

@Repository
class MybatisUserRepository(
    private val userMapper: UserMapper
) : UserRepository {
    override fun findByEmail(email: String): User? = userMapper.findByEmail(email)?.toEntity()
    override fun findByEmailAndPassword(email: String, password: String): User? = userMapper.findByEmailAndPassword(email, password)?.toEntity()
    override fun save(user: User) = userMapper.save(user)
}
