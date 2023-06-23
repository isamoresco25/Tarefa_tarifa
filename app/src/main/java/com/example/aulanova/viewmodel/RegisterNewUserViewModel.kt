package com.example.aulanova.viewmodel

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.example.aulanova.entity.User
import com.example.aulanova.repository.UserRepository


class RegisterNewUserViewModel(private val userRepository: UserRepository): ViewModel() {
    var name by mutableStateOf("")
    var email by mutableStateOf("")
    var password by mutableStateOf("")

    fun registrar() {
        val newUser = User(name = name, email = email, password = password)
        userRepository.addUser(newUser)
    }
}