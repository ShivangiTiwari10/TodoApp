package com.example.todolistapp.data

import kotlinx.coroutines.flow.Flow

interface TaskRepository {

    fun getAllItemsStream(): Flow<List<Task>>

    fun getItemStream(id: Int): Flow<Task?>


    suspend fun insertItem(task: Task)


    suspend fun deleteItem(task: Task)


    suspend fun updateItem(task: Task)
}

