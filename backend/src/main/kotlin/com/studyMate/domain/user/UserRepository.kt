package com.studyMate.domain.user

interface UserRepository {
    fun findAll(): List<User>
}
