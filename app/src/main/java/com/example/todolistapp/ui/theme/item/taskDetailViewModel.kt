package com.example.todolistapp.ui.theme.item

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.todolistapp.data.TaskRepository
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class TaskDetailsViewModel(
    savedStateHandle: SavedStateHandle,
    private val taskRepository: TaskRepository,
) : ViewModel() {

    private val itemId: Int = checkNotNull(savedStateHandle[TaskDetailsDestination.itemIdArg])

    val uiState: StateFlow<TaskDetailsUiState> =
        taskRepository.getItemStream(itemId)
            .filterNotNull()
            .map {
                TaskDetailsUiState(outOfStock = it.description <= 0.toString(), taskDetails = it.toItemDetails())
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = TaskDetailsUiState()
            )


    suspend fun deleteItem() {
        taskRepository.deleteItem(uiState.value.taskDetails.toItem())
    }

    companion object {
        private const val TIMEOUT_MILLIS = 5_000L
    }
}


data class TaskDetailsUiState(
    val outOfStock: Boolean = true,
    val taskDetails: TaskDetails = TaskDetails()
)