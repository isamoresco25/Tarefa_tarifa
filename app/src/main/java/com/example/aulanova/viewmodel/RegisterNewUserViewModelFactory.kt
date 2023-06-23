package com.example.aulanova.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.aulanova.database.AppDatabase
import com.example.aulanova.repository.UserRepository

class RegisterNewUserViewModelFactory(val application: Application) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {

        val dao = AppDatabase.getDatabase(application).userDao()
        val userRepository = UserRepository(dao)
        return RegisterNewUserViewModel(userRepository) as T
    }
}
