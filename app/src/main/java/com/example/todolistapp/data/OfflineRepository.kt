package com.example.todolistapp.data

import kotlinx.coroutines.flow.Flow

class OfflineRepository(private val taskDao: TaskDao) : TaskRepository {
    override fun getAllItemsStream(): Flow<List<Task>> =
        taskDao.getAllItems()


    override fun getItemStream(id: Int): Flow<Task?> =
        taskDao.getItem(id)


    override suspend fun insertItem(task: Task)=
        taskDao.insert(task)


    override suspend fun deleteItem(task: Task) =
        taskDao.delete(task)


    override suspend fun updateItem(task: Task) {

        taskDao.update(task)
    }
}