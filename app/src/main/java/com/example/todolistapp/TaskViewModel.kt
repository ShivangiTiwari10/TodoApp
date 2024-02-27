//package com.example.todolistapp
//
//import androidx.lifecycle.ViewModel
//import dagger.hilt.android.lifecycle.HiltViewModel
//import kotlinx.coroutines.flow.StateFlow
//import javax.inject.Inject
//
////class TaskViewModel {
////}
//@HiltViewModel
//class TaskViewModel @Inject constructor(private val taskDao: TaskDao) : ViewModel() {
//    val tasks: StateFlow<List<Task>> = taskDao.getAllTasks().asStateFlow()
//
//    fun insertTask(task: Task) = viewModelScope.launch {
//        taskDao.insertTask(task)
//    }
//}