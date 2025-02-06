package com.hg.jps.demo14

import android.os.AsyncTask
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.hg.jps.R

class Demo14Activity : AppCompatActivity() {

    private lateinit var adapter: StudentRecyclerViewAdapter
    private lateinit var studentDao: StudentDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_demo14)

        findViewById<Button>(R.id.demo14_add_btn).setOnClickListener { view -> mInsert(view) }
        findViewById<Button>(R.id.demo14_delete_btn).setOnClickListener { view -> mDelete(view) }
        findViewById<Button>(R.id.demo14_update_btn).setOnClickListener { view -> mUpdate(view) }
        findViewById<Button>(R.id.demo14_query_btn).setOnClickListener { view -> mQuery(view) }

        val recyclerView: RecyclerView = findViewById(R.id.demo14_list_view)
        val students = mutableListOf<Student>()
        adapter = StudentRecyclerViewAdapter(students)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = adapter

        val database = MyDatabase.getInstance(this)
        studentDao = database.getStudentDao()

    }

    fun mInsert(view: View) {
        val s1 = Student("Jack", 12)
        val s2 = Student("小华", 18)
        InsertStudentTask(studentDao).execute(s1, s2)
    }

    // 异步任务已过时，可用协程改造
    class InsertStudentTask(private val studentDao: StudentDao) : AsyncTask<Student, Void, Void>() {
        override fun doInBackground(vararg student: Student): Void? {
            studentDao.insertStudent(*student)
            Log.i("JY>>", "Insert 完成.")
            return null
        }
    }

    fun mDelete(view: View) {
        val s1 = Student(2)
        DeleteStudentTask(studentDao).execute(s1)
    }

    class DeleteStudentTask(private val studentDao: StudentDao) : AsyncTask<Student, Void, Void>() {
        override fun doInBackground(vararg students: Student): Void? {
            studentDao.deleteStudent(*students)
            return null
        }
    }

    fun mUpdate(view: View) {
        val s1 = Student(3, "Jason", 22)
        UpdateStudentTask(studentDao).execute(s1)
    }

    class UpdateStudentTask(private val studentDao: StudentDao) : AsyncTask<Student, Void, Void>() {
        override fun doInBackground(vararg students: Student): Void? {
            studentDao.updateStudent(*students)
            return null
        }
    }

    fun mQuery(view: View) {
        GetAllStudentTask(studentDao, adapter).execute()
    }

    class GetAllStudentTask(
        private val studentDao: StudentDao,
        private val adapter: StudentRecyclerViewAdapter
    ) : AsyncTask<Void, Void, Void>() {
        override fun doInBackground(vararg voids: Void?): Void? {
            val students = studentDao.getAllStudent()
            adapter.students = students
            Log.i("JY>>", "查询：" + students.size)
            for (s: Student in students) {
                Log.i("JY>>", ">>：" + s.id + " " + s.name + " " + s.age )
            }
            return null
        }

        override fun onPostExecute(result: Void?) {
            super.onPostExecute(result)
            Log.i("JY>>", "通知更新...：")
            adapter.notifyDataSetChanged()
        }
    }
}