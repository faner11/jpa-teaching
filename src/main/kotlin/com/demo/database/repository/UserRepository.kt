package com.demo.database.repository

import com.demo.database.model.User
import com.demo.database.model.UserNameDto
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.transaction.annotation.Transactional

/**
 * @author fh
 * @since 2019/12/7
 */

interface UserRepository : JpaRepository<User, Long> {
    @Transactional
    @Modifying
    @Query("update User set age = ?1,lastModifyTime=current_timestamp where autoId = ?2")
    fun modifyAgeById(age: Int, autoId: Long): Int

    @Transactional
    @Modifying
    @Query("update User set age = :#{#user.age},lastModifyTime=current_timestamp where autoId = :#{#user.autoId}")
    fun modifyAgeByIdV2(@Param("user") user:User): Int

    @Transactional
    @Modifying
    fun deleteByAgeIn(age: List<Int>):Int

    @Query("select new map(autoId,name) from User")
    fun findNames():List<Map<String,Any>>

    @Query("select new com.demo.database.model.UserNameDto(autoId,name) from User")
    fun findNamesV2():List<UserNameDto>
}