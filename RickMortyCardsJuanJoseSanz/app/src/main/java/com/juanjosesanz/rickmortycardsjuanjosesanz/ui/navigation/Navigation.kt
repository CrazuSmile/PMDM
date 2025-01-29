package com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation

import androidx.activity.compose.BackHandler
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.Onboarding1Screen
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.Onboarding2Screen
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.Onboarding3Screen
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.Onboarding4Screen
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.SplashScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Splash
    ) {
        composable<Splash> {
            SplashScreen(navController)
        }

        composable<Onboarding1> {
            Onboarding1Screen(navController)
        }

        composable<Onboarding2> {
            Onboarding2Screen(navController)
        }

        composable<Onboarding3> {
            Onboarding3Screen(navController)
        }

        composable<Onboarding4> {
            Onboarding4Screen(navController)
        }
    }

    BackHandler(enabled = true) { }

}