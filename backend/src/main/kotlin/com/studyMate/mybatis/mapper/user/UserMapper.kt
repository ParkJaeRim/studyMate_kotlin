package com.studyMate.mybatis.mapper.user

import com.studyMate.mybatis.values.user.UserVo
import org.apache.ibatis.annotations.Mapper

@Mapper
interface UserMapper {
    fun findAll(): List<UserVo>
}
