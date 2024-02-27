package com.example.todolistapp

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Task(
    @PrimaryKey(autoGenerate = true) val id: Long,
    val todo: String,
    val time: String,
    var isComplete: Int = 0,

)
