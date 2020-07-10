package com.example.mvvmroom.information

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmroom.database.StudentRepository
import com.example.mvvmroomrecyclerviewex.information.InfoViewModel
import java.lang.IllegalArgumentException

class InfoViewModelFactory(private val studentRepository: StudentRepository,
                           private val studentId:Long):ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(InfoViewModel::class.java)) {
            return InfoViewModel(studentRepository, studentId) as T
        }
        throw IllegalArgumentException("unkown viewModel class!")
    }
}