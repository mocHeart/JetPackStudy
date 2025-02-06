package com.hg.jps.demo14

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey

@Entity(tableName = "student")
class Student(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id", typeAffinity = ColumnInfo.INTEGER)
    var id: Int?,

    @ColumnInfo(name = "name", typeAffinity = ColumnInfo.TEXT)
    var name: String?,

    @ColumnInfo(name = "age", typeAffinity = ColumnInfo.INTEGER)
    var age: Int?
) {

    // @Ignore 表示Room框架会忽略该属性, 表中不会生成该字段
    @Ignore
    var flag: Boolean = false

    // @Ignore 表示Room框架会忽略该构造函数
    @Ignore
    constructor(name: String, age: Int) : this(null, name, age)

    @Ignore
    constructor(id: Int) : this(id, null, null)
}