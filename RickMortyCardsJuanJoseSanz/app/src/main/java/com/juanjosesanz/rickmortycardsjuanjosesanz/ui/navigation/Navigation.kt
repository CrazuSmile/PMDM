package com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.Onboarding1Screen
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens.Onboarding2Screen
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
    }
}