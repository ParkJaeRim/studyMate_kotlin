package com.studyMate.domain.study

interface StudyRepository {
    fun findAll(): List<Study>
}
