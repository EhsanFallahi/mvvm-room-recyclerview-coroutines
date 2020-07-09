package com.example.mvvmroom.login

import android.app.Application
import android.widget.Toast
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmroom.database.Student
import com.example.mvvmroom.database.StudentDao
import com.example.mvvmroom.database.StudentRepository
import kotlinx.coroutines.*
import java.sql.Struct

class LoginViewModel(
    val studentRepository: StudentRepository,
    val application: Application
) : ViewModel(),Observable {



    @Bindable
    val userName=MutableLiveData<String>()
    @Bindable
    val email=MutableLiveData<String>()
    @Bindable
    val password=MutableLiveData<String>()
    @Bindable
    val phoneNumber=MutableLiveData<String>()

    val viewModelJob= Job()
    val uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)

    fun insert(student: Student):Job= viewModelScope.launch { studentRepository.insert(student)}
    fun update(student: Student):Job=viewModelScope.launch {studentRepository.update(student) }
    fun clearStudent(student: Student):Job=viewModelScope.launch { studentRepository.clearStudent(student) }
    fun clearAllStudent():Job=viewModelScope.launch { studentRepository.clearAll() }
    fun getStudent(key:Long)=studentRepository.getStudent(key)
    fun getAllStudent()=studentRepository.students


    fun saveStudent(){
        insert(Student(0,userName.value,email.value, password.value!!))
        Toast.makeText(application,"Success Login",Toast.LENGTH_SHORT).show()
        resteValue()
    }

    private fun resteValue() {
        userName.value=null
        email.value=null
        password.value=null
        phoneNumber.value=null
    }



    override fun onCleared() {
        super.onCleared()
        viewModelJob.cancel()
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {

    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
    }

}