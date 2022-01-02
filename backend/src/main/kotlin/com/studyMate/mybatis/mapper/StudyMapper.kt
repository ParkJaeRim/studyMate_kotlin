package com.studyMate.mybatis.mapper

import com.studyMate.mybatis.values.StudyVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface StudyMapper {
    fun findAll(): List<StudyVo>
}
