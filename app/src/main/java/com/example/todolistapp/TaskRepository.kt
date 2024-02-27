package com.example.todolistapp

import kotlinx.coroutines.Dispatchers

class TaskRepository(private val taskDao: TaskDao) {
    val selectAll = taskDao.selectAll()

    suspend fun insertTodo(task: Task) {
        Dispatchers.IO.apply {
            taskDao.insert(task )
        }
    }
    suspend fun deleteTask(task: Task) {
        Dispatchers.IO.apply {
            taskDao.deleteTask(task.id)
        }
    }

    suspend fun updateTask(isComplete: Boolean, id: Long) {
        Dispatchers.IO.apply {
            taskDao.updateTask(isComplete, id)
        }
    }
}