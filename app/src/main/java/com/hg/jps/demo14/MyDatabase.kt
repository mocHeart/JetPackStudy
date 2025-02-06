package com.hg.jps.demo14

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Student::class], version = 1, exportSchema = false)
abstract class MyDatabase : RoomDatabase() {

    companion object {
        private const val DATABASE_NAME: String = "my_db.db"
        private var mInstance: MyDatabase? = null

        fun getInstance(context: Context): MyDatabase {
            if (mInstance == null) {
                mInstance = Room.databaseBuilder(
                    context.applicationContext,
                    MyDatabase::class.java,
                    DATABASE_NAME
                )
                    //.allowMainThreadQueries()  // Room默认不允许主线程操作数据库，使用该配置强制采用在主线程操作数据库
                    .build()
            }
            return mInstance!!
        }
    }

    abstract fun getStudentDao(): StudentDao

}