package com.juanjosesanz.taskmanager.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.juanjosesanz.taskmanager.tasks.ui.viewmodel.TaskViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TaskInfoScreen(navController: NavController, id: Int) {
    val taskViewModel: TaskViewModel = viewModel()
    val username = taskViewModel.username.value
    if (username != null) {
        taskViewModel.initDataBase(username)
    }
    LaunchedEffect(id) {
        taskViewModel.getTaskById(id)
    }
    val task = taskViewModel.selectedTask.observeAsState()
    val inputDescription = task.value?.description.orEmpty()
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { Text(text = task.value?.name ?: "Tarea no encontrada") }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier.padding(paddingValues)
        ) {
            TextField(value = inputDescription,
                onValueChange = { newDescription ->
                    val updatedTask = task.value?.copy(description = newDescription)
                    if (updatedTask != null) {
                        taskViewModel.updateTask(
                            updatedTask,
                            isDone = updatedTask.isDone,
                            newDescription
                        )
                    }
                }

            )
        }
    }
}