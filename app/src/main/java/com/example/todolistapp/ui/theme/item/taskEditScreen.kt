package com.example.todolistapp.ui.theme.item

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.todolistapp.AppViewModelProvider
import com.example.todolistapp.R
import com.example.todolistapp.TaskTopAppBar
import com.example.todolistapp.navigation.NavigationDestination
import kotlinx.coroutines.launch


object TaskEditDestination : NavigationDestination {
    override val route = "item_edit"
    override val titleRes = R.string.edit_item_title
    const val itemIdArg = "itemId"
    val routeWithArgs = "$route/{$itemIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskEditScreen(
    navigateBack: () -> Unit,
    onNavigateUp: () -> Unit,
    modifier: Modifier = Modifier,
    viewModel: TaskEditVieModel = viewModel(factory = AppViewModelProvider.Factory)
) {
    val coroutineScope = rememberCoroutineScope()
    Scaffold(
        topBar = {
            TaskTopAppBar(
                title = stringResource(TaskEditDestination.titleRes),
                canNavigateBack = true,
                navigateUp = onNavigateUp
            )
        },
        modifier = modifier
    ) { innerPadding ->
        TaskEntryBody(
            itemUiState = viewModel.itemUiState,
            onItemValueChange =  viewModel::updateUiState,
            onSaveClick ={
                coroutineScope.launch {
                    viewModel.updateItem()
                    navigateBack()
                }
            },

            modifier = Modifier.padding(innerPadding)
        )
    }
}

