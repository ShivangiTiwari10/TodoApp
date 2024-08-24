package com.example.todolistapp

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.todolistapp.ui.theme.home.HomeViewModel
import com.example.todolistapp.ui.theme.item.TaskDetailsViewModel
import com.example.todolistapp.ui.theme.item.TaskEditVieModel
import com.example.todolistapp.ui.theme.item.TaskEntryViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            TaskEditVieModel(
                this.createSavedStateHandle(),
                taskApplication().container.taskRepository
            )
        }
        initializer {
            TaskEntryViewModel(taskApplication().container.taskRepository)
        }

        initializer {
            TaskDetailsViewModel(
                this.createSavedStateHandle(),
                taskApplication().container.taskRepository
            )
        }

        initializer {
            HomeViewModel(taskApplication().container.taskRepository)
        }
    }
}

fun CreationExtras.taskApplication(): TaskApplication =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as TaskApplication)