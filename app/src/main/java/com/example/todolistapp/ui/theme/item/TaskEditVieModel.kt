package com.example.todolistapp.ui.theme.item

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.data.TaskRepository
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class TaskEditVieModel(
    savedStateHandle: SavedStateHandle,
    private val tasksRepository: TaskRepository
) : ViewModel(){

    var itemUiState by mutableStateOf(TaskUiState())
        private set

    private val taskId: Int = checkNotNull(savedStateHandle[TaskEditDestination.itemIdArg])

    init {
        viewModelScope.launch {
            itemUiState = tasksRepository.getItemStream(taskId)
                .filterNotNull()
                .first()
                .toTaskUiState(true)
        }
    }


    suspend fun updateItem() {
        if (validateInput(itemUiState.taskDetails)) {
            tasksRepository.updateItem(itemUiState.taskDetails.toItem())
        }
    }


    fun updateUiState(itemDetails: TaskDetails) {
        itemUiState =
            TaskUiState(taskDetails = itemDetails, isEntryValid = validateInput(itemDetails))
    }



    private fun validateInput(uiState: TaskDetails = itemUiState.taskDetails): Boolean {
        return with(uiState) {
            name.isNotBlank()  && description.isNotBlank()
        }
    }


}