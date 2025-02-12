package com.juanjosesanz.taskmanager.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.toRoute
import com.juanjosesanz.taskmanager.tasks.ui.MainScreen
import com.juanjosesanz.taskmanager.tasks.ui.viewmodel.OnBoardingTaskViewModel
import com.juanjosesanz.taskmanager.tasks.ui.viewmodel.TaskViewModel
import com.juanjosesanz.taskmanager.ui.screens.OnBoardingScreen
import com.juanjosesanz.taskmanager.ui.screens.SplashScreen
import com.juanjosesanz.taskmanager.ui.screens.TaskInfoScreen


@Composable
fun Navigation(taskViewModel: TaskViewModel, onBoardingTaskViewModel: OnBoardingTaskViewModel) {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash
    ) {
        composable<Routes.Splash> {
            SplashScreen(navController, taskViewModel)
        }

        composable<Routes.Main> {
            MainScreen(taskViewModel, navController)
        }

        composable<Routes.OnBoarding> {
            OnBoardingScreen(navController, onBoardingTaskViewModel)
        }

        composable<Routes.TaskInfo> {
            val args = it.toRoute<Routes.TaskInfo>()
            TaskInfoScreen(navController, args.id)
        }
    }
}

