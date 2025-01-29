package com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Main
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Onboarding1

@Composable
fun Onboarding4Screen(navController: NavController) {
    var textFieldValue by rememberSaveable { mutableStateOf("") }

    fun notValid(textFieldValue: String): Boolean {
        return textFieldValue.isNotBlank() && !textFieldValue.any { it.isDigit() }
    }

    val buttonEnabled = notValid(textFieldValue)

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = textFieldValue,
            label = { Text("Your name") },
            onValueChange = { textFieldValue = it },
        )
        if (textFieldValue.any { it.isDigit() }) {
            Text(
                "Please insert a name without digits."
            )
        }
        Spacer(Modifier.padding(10.dp))

        Button(
            enabled = buttonEnabled,
            onClick = {
                navController.navigate(Main)
            }
        ) {
            Text(
                "Sign in"
            )
        }
        Spacer(Modifier.padding(20.dp))
        Button(
            onClick = {
                navController.navigate(Onboarding1) {
                    popUpTo<Onboarding1> {
                        inclusive = true
                    }
                }
            }
        ) {
            Text(
                "Restart"
            )
        }

    }
}