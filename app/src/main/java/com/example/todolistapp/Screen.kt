package com.example.todolistapp

sealed  class Screen(val route: String) {

    data object All : Screen("all")
    data object Completed : Screen("completed")
}  