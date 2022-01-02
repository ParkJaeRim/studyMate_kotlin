package com.studyMate.mybatis.mapper.study

import com.studyMate.mybatis.values.study.StudyVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface StudyMapper {
    fun findAll(): List<StudyVo>
}
