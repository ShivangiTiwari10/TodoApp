package com.example.todolistapp


import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox

import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHost
import androidx.navigation.compose.rememberNavController


@Composable
fun Add() {
    TextInputs()

}

@Composable
fun TextInputs() {
    Column {

        Text(text = "Add Task")
        var text by remember { mutableStateOf(TextFieldValue("")) }

        TextField(
            value = text,
            onValueChange = { newValue -> text = newValue },

            label = { Text("Task Name") },
            placeholder = { Text("placeholder") },
        )


        var numberText by remember { mutableStateOf(TextFieldValue("")) }

        OutlinedTextField(value = numberText,

            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
            label = { Text(text = "Due Date") },
            placeholder = { Text(text = "12/02/2023") },
            onValueChange = {
                numberText = it
            }
        )
        val checkedState = remember { mutableStateOf(true) }
        Checkbox(

            checked = checkedState.value,

            modifier = Modifier.padding(16.dp),

            onCheckedChange = { checkedState.value = it },
        )
        Button(

            modifier = Modifier.size(width = 100.dp, height = 50.dp),
            onClick = {

            }
        ) {
            Text(text = "Add", fontSize = 20.sp)

        }
    }

}