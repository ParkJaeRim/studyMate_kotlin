package com.studyMate.domain.user

interface UserRepository {
    fun findByEmail(email: String): User?
    fun findByEmailAndPassword(email: String, password: String): User?
    fun save(user: User)
}
