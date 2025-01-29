package com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.sharp.KeyboardArrowRight
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavController
import com.juanjosesanz.rickmortycardsjuanjosesanz.R
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Onboarding2
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Onboarding4

@Composable
fun Onboarding1Screen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Image(
            painter = painterResource(R.drawable.rymlogo),
            contentDescription = "Logo"
        )
        Image(
            painter = painterResource(R.drawable.rymportal),
            contentDescription = "Portal"
        )
        Row {
            IconButton(
                onClick = {
                    navController.navigate(Onboarding2)
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                    contentDescription = "Next"
                )
            }
            TextButton(
                onClick = {
                    navController.navigate(Onboarding4)
                }
            ) {
                Text("Skip")
            }
        }

    }
}