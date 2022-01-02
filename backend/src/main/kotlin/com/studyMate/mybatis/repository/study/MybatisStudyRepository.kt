package com.studyMate.mybatis.repository.study

import com.studyMate.domain.study.Study
import com.studyMate.domain.study.StudyRepository
import com.studyMate.mybatis.mapper.study.StudyMapper
import org.springframework.stereotype.Repository

@Repository
class MybatisStudyRepository(
    private val studyMapper: StudyMapper
) : StudyRepository {
    override fun findAll(): List<Study> = studyMapper.findAll().map{ studyVo -> studyVo.toEntity() }
}
