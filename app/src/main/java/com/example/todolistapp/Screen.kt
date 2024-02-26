package com.example.todolistapp

sealed  class Screen(val route: String) {
    object All : Screen("all")
    object Completed : Screen("completed")
}
val bottomNavItems = listOf(
    Screen.All,
    Screen.Completed,
)