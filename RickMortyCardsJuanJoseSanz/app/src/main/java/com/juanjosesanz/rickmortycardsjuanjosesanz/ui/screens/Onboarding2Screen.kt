package com.juanjosesanz.rickmortycardsjuanjosesanz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.juanjosesanz.rickmortycardsjuanjosesanz.R
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Onboarding3
import com.juanjosesanz.rickmortycardsjuanjosesanz.ui.navigation.Onboarding4

@Composable
fun Onboarding2Screen(navController: NavController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Image(
                painter = painterResource(R.drawable.card1),
                contentDescription = "Carta 1",
                modifier = Modifier.size(200.dp, 200.dp)
            )
            Image(
                painter = painterResource(R.drawable.card2),
                contentDescription = "Carta 2",
                modifier = Modifier.size(200.dp, 200.dp)

            )


        }
        Image(
            painter = painterResource(R.drawable.card3),
            contentDescription = "Carta 3",
            modifier = Modifier.size(200.dp, 200.dp)

        )
        Row {
            IconButton(
                onClick = {
                    navController.navigate(Onboarding3)

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