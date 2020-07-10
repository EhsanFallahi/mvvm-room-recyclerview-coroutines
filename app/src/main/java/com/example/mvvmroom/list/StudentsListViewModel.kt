package com.example.mvvmroom.list

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroom.database.Student
import com.example.mvvmroom.database.StudentRepository
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch

class StudentsListViewModel(
    val studentRepository: StudentRepository,
    val application: Application
) : ViewModel() {

    val getAllStudents=studentRepository.students
    fun clearStudent(student: Student): Job =viewModelScope.launch { studentRepository.clearStudent(student) }
    fun clearAllStudent(): Job =viewModelScope.launch { studentRepository.clearAll() }

    private val _navigateToInfoFragment= MutableLiveData<Student>()
    val navigateToInfoFragmentVal: LiveData<Student>
        get()=_navigateToInfoFragment
    fun doneNavigating(){
        _navigateToInfoFragment.value=null
    }

    fun clearAll(){

        clearAllStudent()
    }

}