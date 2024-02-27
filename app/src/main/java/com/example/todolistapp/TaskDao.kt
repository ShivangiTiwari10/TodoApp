package com.example.todolistapp

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import kotlinx.coroutines.flow.Flow


@Dao
interface TaskDao {




    @Query("Select * from task")
    fun selectAll(): Flow<List<Task>>
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(task: Task)

    @Query("Delete from Task where id=:id")
    suspend fun deleteTask(id:Long)

    @Query("DELETE FROM task")
    suspend fun deleteAllTodo()

    @Query("UPDATE task SET isComplete = :isComplete WHERE id = :id")
    suspend fun updateTask(isComplete: Boolean, id: Long)


}