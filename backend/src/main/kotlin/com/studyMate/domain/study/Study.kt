package com.studyMate.domain.study

import com.studyMate.domain.Category
import java.time.LocalDate

//NOTE 느낀점 : 무작위한 필드추가 , Enum 추가의 효율성
data class Study(

    var id: Int,

    var title: String,

    var category: Category,

    /**
     * user 테이블의 id의 FK
     * 스터디의 리더 정보
     */
    var leaderId: Int,

    var startTime: LocalDate,

    var endTime: LocalDate,

    /**
     * string이 아닌 list로 받아오고 저장할 수 있는 방법에 대해 생각하기
     */
//    var studyMemberId: List<Int>,
    var studyMemberId: String,

    var limitMember: Int,

    var backgroundImage: String,

    )
