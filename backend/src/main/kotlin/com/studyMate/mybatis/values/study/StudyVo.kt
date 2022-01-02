package com.studyMate.mybatis.values.study

import com.studyMate.domain.Category
import com.studyMate.domain.study.Study
import org.apache.ibatis.type.Alias
import java.time.LocalDate

@Alias("study")
data class StudyVo (
    var id: Int,
    var title: String,
    var category: Category,
    var leaderId: Int,
    var startTime: LocalDate,
    var endTime: LocalDate,
//    var studyMemberId: List<Int>,
    var studyMemberId: String,
    var limitMember: Int,
    var backgroundImage: String,
){
    fun toEntity(): Study {
        return Study(id, title, category, leaderId, startTime, endTime, studyMemberId, limitMember, backgroundImage)
    }
}
