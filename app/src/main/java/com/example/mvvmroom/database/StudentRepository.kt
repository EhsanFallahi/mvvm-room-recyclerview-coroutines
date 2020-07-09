package com.example.mvvmroom.database

import androidx.lifecycle.LiveData

class StudentRepository (private val studentDao: StudentDao){

    val students=studentDao.getAllStudent()


    suspend fun insert(student: Student){
        studentDao.insert(student)
    }

    suspend fun update(student: Student){
        studentDao.update(student)
    }

     fun getStudent(key:Long): LiveData<Student> {
        return studentDao.getStudent(key)
    }


    suspend fun clearAll(){
        studentDao.clearAll()
    }

    suspend fun clearStudent(student:Student){
        studentDao.deleteStudent(student)
    }

}