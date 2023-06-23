package com.example.aulanova.repository

import com.example.aulanova.dao.UserDao
import com.example.aulanova.entity.User
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserRepository(private val userDao: UserDao) {

    private val coroutine = CoroutineScope(Dispatchers.Main)

    fun addUser(user: User) {
        coroutine.launch(Dispatchers.IO) {
            userDao.insert(user)
        }
    }
}