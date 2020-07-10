package com.example.mvvmroom.login

import android.app.Application
import android.util.Patterns
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


    val viewModelJob= Job()
    val uiScope= CoroutineScope(Dispatchers.Main+viewModelJob)

    fun insert(student: Student):Job= viewModelScope.launch { studentRepository.insert(student)}
    fun update(student: Student):Job=viewModelScope.launch {studentRepository.update(student) }


    fun getAllStudent()=studentRepository.students


    fun saveStudent(){
        if (userName.value.isNullOrEmpty()){
            Toast.makeText(application,"please enter userName",Toast.LENGTH_SHORT).show()
        }else if (email.value.isNullOrEmpty()){
            Toast.makeText(application,"please enter email",Toast.LENGTH_SHORT).show()
        }else if(password.value.isNullOrEmpty()){
            Toast.makeText(application,"please enter password",Toast.LENGTH_SHORT).show()
        }else if(!Patterns.EMAIL_ADDRESS.matcher(email.value).matches()){
            Toast.makeText(application,"please enter correct email address",Toast.LENGTH_SHORT).show()
        }else{
            insert(Student(0,userName.value,email.value, password.value!!))
            Toast.makeText(application,"Success Login",Toast.LENGTH_SHORT).show()
            resteValue()
        }

    }

    private fun resteValue() {
        userName.value=null
        email.value=null
        password.value=null

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