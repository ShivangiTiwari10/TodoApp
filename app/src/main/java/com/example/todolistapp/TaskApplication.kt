package com.example.todolistapp

import android.app.Application
import com.example.todolistapp.data.AppContainer
import com.example.todolistapp.data.AppDataContainer

class TaskApplication: Application() {

    lateinit var container: AppContainer

    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }

}