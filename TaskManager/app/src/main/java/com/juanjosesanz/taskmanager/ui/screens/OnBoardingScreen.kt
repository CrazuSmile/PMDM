package com.juanjosesanz.taskmanager.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.juanjosesanz.taskmanager.navigation.Routes
import com.juanjosesanz.taskmanager.tasks.ui.viewmodel.OnBoardingTaskViewModel

@Composable
fun OnBoardingScreen(
    navController: NavController,
    onBoardingTaskViewModel: OnBoardingTaskViewModel
) {
    val inputUsername by onBoardingTaskViewModel.username.observeAsState(initial = "")
    val enabledButton = remember {
        derivedStateOf {
            inputUsername.isNotEmpty()
        }
    }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            "Bienvenido",
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp
        )
        TextField(
            value = inputUsername,
            onValueChange = { onBoardingTaskViewModel.onUsernameChange(it) },
            label = { Text("Nombre de usuario...") }
        )
        Button(
            onClick = {
                onBoardingTaskViewModel.saveUsername(inputUsername)
                navController.navigate(Routes.Main)
            },
            enabled = enabledButton.value
        ) {
            Text(
                "Crear Usuario"
            )
        }
    }
}