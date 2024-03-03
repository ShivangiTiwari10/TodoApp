package com.example.todolistapp.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.inventory.ui.home.HomeDestination
import com.example.inventory.ui.home.HomeScreen
import com.example.todolistapp.ui.theme.item.TaskDetailsDestination
import com.example.todolistapp.ui.theme.item.TaskDetailsScreen
import com.example.todolistapp.ui.theme.item.TaskEditDestination
import com.example.todolistapp.ui.theme.item.TaskEditScreen
import com.example.todolistapp.ui.theme.item.TaskEntryDestination
import com.example.todolistapp.ui.theme.item.TaskEntryScreen


@Composable
fun  TaskNavHost(navController: NavHostController,
                  modifier: Modifier = Modifier,) {

    NavHost(
    navController = navController, startDestination = HomeDestination.route, modifier = modifier){
        composable(route = HomeDestination.route) {
            HomeScreen(navigateToItemEntry = { navController.navigate(TaskEntryDestination.route) },
                navigateToItemUpdate = {
                    navController.navigate("${TaskDetailsDestination.route}/${it}")
                })
        }

        composable(route = TaskEntryDestination.route) {
            TaskEntryScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
        composable(
            route = TaskDetailsDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskDetailsDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskDetailsScreen(
                navigateToEditItem =
                {
                    navController.navigate("${TaskEditDestination.route}/$it")
                },
                navigateBack = { navController.navigateUp() })
        }
        composable(
            route = TaskEditDestination.routeWithArgs,
            arguments = listOf(navArgument(TaskEditDestination.itemIdArg) {
                type = NavType.IntType
            })
        ) {
            TaskEditScreen(navigateBack = { navController.popBackStack() },
                onNavigateUp = { navController.navigateUp() })
        }
    }
    }
