package com.example.todolistapp.ui.theme.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.todolistapp.data.Task
import com.example.todolistapp.data.TaskRepository

class TaskEntryViewModel(private val taskRepository: TaskRepository) : ViewModel() {


    var taskUiState by mutableStateOf(TaskUiState())
        private set


    fun updateUiState(taskDetails: TaskDetails) {
        taskUiState =
            TaskUiState(taskDetails = taskDetails, isEntryValid = validateInput(taskDetails))
    }

    suspend fun saveItem() {
        if (validateInput()) {
            taskRepository.insertItem(taskUiState.taskDetails.toItem())
        }
    }

    private fun validateInput(uiState: TaskDetails = taskUiState.taskDetails): Boolean {
        return with(uiState) {
            name.isNotBlank() && description.isNotBlank()
        }
    }
}
data class TaskUiState(
    val taskDetails: TaskDetails = TaskDetails(),
    val isEntryValid: Boolean = false
)

data class TaskDetails(
    val id: Int = 0,
    val name: String = "",
    val description: String = "",
    val isChecked : Boolean = false
)


fun TaskDetails.toItem(): Task = Task(
    id = id,
    name = name,
    description = description,
    isChecked = isChecked
)



fun Task.toTaskUiState(isEntryValid: Boolean = false): TaskUiState = TaskUiState(
    taskDetails = this.toItemDetails(),
    isEntryValid = isEntryValid
)

fun Task.toItemDetails(): TaskDetails = TaskDetails(
    id = id,
    name = name,
    description = description,
    isChecked = isChecked

)