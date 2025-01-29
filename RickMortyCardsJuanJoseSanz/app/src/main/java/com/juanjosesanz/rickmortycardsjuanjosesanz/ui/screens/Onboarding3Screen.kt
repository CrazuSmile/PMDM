package com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens

import androidx.activity.compose.BackHandler
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
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.navigation.NavController
import com.juanjosesanz.rickmortycardsjuanjosesanz.R
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Onboarding4

@Composable
fun Onboarding3Screen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Paz entre los mundos",
            fontWeight = FontWeight.Bold
        )
        Image(
            painter = painterResource(R.drawable.pazentremundos),
            contentDescription = "Peace between the worlds"
        )
        Row {
            IconButton(
                onClick = {
                    navController.navigate(Onboarding4)
                }
            ) {
                Icon(
                    imageVector = Icons.AutoMirrored.Sharp.KeyboardArrowRight,
                    contentDescription = "Next"
                )
            }
        }
    }
}