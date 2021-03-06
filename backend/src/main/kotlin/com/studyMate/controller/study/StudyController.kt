package com.studyMate.controller.study

import com.studyMate.domain.study.Study
import com.studyMate.mybatis.repository.MybatisStudyRepository
import org.springframework.web.bind.annotation.CrossOrigin
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@CrossOrigin(origins = ["*"])
@RestController
class StudyController(private val studyRepository: MybatisStudyRepository) {
    @GetMapping("/test")
    fun test():  List<Study> {
        val result : List<Study> = studyRepository.findAll()
        println(result)
        return result;
    }
}
