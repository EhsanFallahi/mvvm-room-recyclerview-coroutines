package com.example.mvvmroom.list

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroom.database.StudentRepository
import com.example.mvvmroom.login.LoginViewModel
import java.lang.IllegalArgumentException

class StudentListViewModelFactory(
    private val studentRepository: StudentRepository,
    private val application: Application
) : ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(StudentsListViewModel::class.java)){
            return StudentsListViewModel(studentRepository,application) as T
        }
        throw IllegalArgumentException("unkown viewModel class!")
    }

}