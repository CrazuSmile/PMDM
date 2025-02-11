package com.juanjosesanz.taskmanager

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import com.juanjosesanz.taskmanager.navigation.Navigation
import com.juanjosesanz.taskmanager.tasks.ui.viewmodel.OnBoardingTaskViewModel
import com.juanjosesanz.taskmanager.tasks.ui.viewmodel.TaskViewModel
import com.juanjosesanz.taskmanager.ui.theme.TaskManagerTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            TaskManagerTheme {
                val taskViewModel by viewModels<TaskViewModel>()
                val onBoardingTaskViewModel by viewModels<OnBoardingTaskViewModel>()
                Navigation(taskViewModel, onBoardingTaskViewModel)
            }
        }
    }
}

