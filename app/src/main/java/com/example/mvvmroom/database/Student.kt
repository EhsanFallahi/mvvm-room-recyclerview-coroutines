package com.example.mvvmroom.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "student_table")
data class Student(
    @PrimaryKey(autoGenerate = true)
    val id:Long,
    @ColumnInfo(name = "user_name")
    val userName:String,
    @ColumnInfo(name = "email")
    val email:String,
    @ColumnInfo(name = "password")
    val password:Int
)