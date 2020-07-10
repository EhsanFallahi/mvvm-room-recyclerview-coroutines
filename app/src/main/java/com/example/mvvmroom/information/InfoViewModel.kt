package com.example.mvvmroomrecyclerviewex.information

import androidx.lifecycle.ViewModel
import com.example.mvvmroom.database.StudentRepository

class InfoViewModel(val studentRepository: StudentRepository, val studentId:Long) : ViewModel() {


    fun getStudent()=studentRepository.getStudent(studentId)

}