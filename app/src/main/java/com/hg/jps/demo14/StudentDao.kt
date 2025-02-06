package com.hg.jps.demo14

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface StudentDao {

    @Insert
    fun insertStudent(vararg students: Student)

    @Delete
    fun deleteStudent(vararg students: Student)

    @Update
    fun updateStudent(vararg students: Student)

    @Query("SELECT * FROM student")
    fun getAllStudent(): List<Student>

    @Query("SELECT * FROM student WHERE id = :id")
    fun getStudentById(id: Int): List<Student>

}