package com.example.mvvmroom.database

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface StudentDao {

    @Insert
    suspend fun insert(student: Student)

    @Update
    suspend fun update(student: Student)

    @Delete
    suspend fun deleteStudent(student: Student)

    @Query("DELETE FROM student_table")
    suspend fun clearAll()

    @Query("SELECT * FROM student_table WHERE id=:key")
    suspend fun getStudent(key:Long):LiveData<Student>

    @Query("SELECT * FROM student_table")
    fun getAllStudent():LiveData<List<Student>>

}