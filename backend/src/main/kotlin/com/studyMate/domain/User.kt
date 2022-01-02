package com.studyMate.domain

import java.time.LocalDateTime

data class User(

    var id: Int,

    var realName: String,

    var nickName: String,

    var password: String,

    var email: String,

    var introduction: String,

    var profileImage: String,

    var penalty : Integer,

    var mileage: String,

    var lastLoginDate: LocalDateTime,

    var dateCreated: LocalDateTime,

)
