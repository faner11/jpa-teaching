package com.demo.database

import com.demo.database.model.User
import com.demo.database.model.UserNameDto
import com.demo.database.repository.UserRepository
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import javax.annotation.Resource

@SpringBootTest
class DatabaseApplicationTests(

) {
    @Resource
    private lateinit var userRepository: UserRepository

    @Test
    fun save() {
        // 保存
        userRepository.save(User(name = "小王"))
    }

    @Test
    fun saveAll() {
        // 批量保存
        val users = listOf<User>(User(name = "小李", age = 18), User(name = "小白"))
        userRepository.saveAll(users)
    }

    @Test
    fun update() {
        // 修改
        val user = userRepository.findById(1).get()
        user.age = 18
        userRepository.save(user)
    }

    @Test
    fun updateAll() {
        // 批量修改
        val users = userRepository.findAll()
        users.map { it.age = 12 }
        userRepository.saveAll(users)
    }

    @Test
    fun modifyAgeById() {
        // 不获取的数据，直接修改
        userRepository.modifyAgeById(22, 1)
    }

    @Test
    fun modifyAgeByIdV2() {
        // 不获取的数据，直接修改v2
        val user = User(age = 18)
        user.autoId = 1
        userRepository.modifyAgeByIdV2(user)

    }

    @Test
    fun delete() {
        // 根据id删除
        userRepository.deleteById(1)
    }


    @Test
    fun deleteAges() {
        // 批量删除
        userRepository.deleteByAgeIn(listOf(12, 13))
    }

    @Test
    fun findNames() {
        // 获取部分字段
        val usersMapList = userRepository.findNames()
        val users = usersMapList.map {
            UserNameDto(it["0"] as Long, it["1"] as String)
        }
        println(users)
    }

    @Test
    fun findNamesV2() {
        val users = userRepository.findNamesV2()
        println(users)
    }

}
