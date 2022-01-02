package com.studyMate.domain

enum class Category(private val type: String) {
    PROJECT("프로젝트"),
    CONTEST("공모전"),
    CERTIFICATE("자격증"),
    ALGORITHM("알고리즘"),
    RESUME("이력서"),
    INTERVIEW("면접");

    fun getType(): String = type
}
