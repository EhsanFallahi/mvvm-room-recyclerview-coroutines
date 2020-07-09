package com.example.mvvmroom.login

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroom.database.StudentRepository
import java.lang.IllegalArgumentException

class LoginViewModelFactory(
    private val studentRepository: StudentRepository,
    private val application: Application
) :ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)){
            return LoginViewModel(studentRepository,application) as T
        }
        throw IllegalArgumentException("unkown viewModel class!")
    }

}