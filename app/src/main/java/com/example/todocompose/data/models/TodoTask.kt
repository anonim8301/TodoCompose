package com.example.todocompose.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.todocompose.utils.Constants.TABLE_NAME

@Entity(tableName = TABLE_NAME)
data class TodoTask(
    @PrimaryKey(autoGenerate = true)
    val id : Int = 0,
    val title :String,
    val description : String,
    val priority: Priority
)
