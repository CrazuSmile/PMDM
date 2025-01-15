package com.juanjosesanz.dragonballjuanjosesanz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.juanjosesanz.dragonballjuanjosesanz.R

@Composable
fun DragonBall(modifier: Modifier) {
    val orange = Color(0xFFF89F02)
    val green = Color(0xFF8BC34A)

    var boxState by rememberSaveable { mutableStateOf(false) }
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopAppBar(title = { Text(text = "Akira Toriyama") }, navigationIcon = {
                Image(
                    painter = painterResource(R.drawable.four_star_ball),
                    contentDescription = "4 star dragon ball",
                    modifier = Modifier.size(50.dp)

                )
            },
                actions = {
                    Image(
                        painter = painterResource(R.drawable.logo_db),
                        contentDescription = "Logo",
                        modifier = Modifier.size(100.dp)

                    )
                }, colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = orange
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    boxState = !boxState
                },
                containerColor = green
            ) {
                Icon(
                    imageVector = Icons.Default.Info,
                    contentDescription = "Author info",
                )
            }
        }) { innerPadding ->
        content(Modifier.padding(innerPadding))
        if (boxState) {
            Box(
                modifier = Modifier
                    .background(color = Color.White),
                contentAlignment = Alignment.Center,
            ) {
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center,
                ) {
                    Image(
                        painter = painterResource(R.drawable.author),
                        contentDescription = "Author",
                        modifier = Modifier.size(300.dp)
                    )
                    Text(
                        """Juan Jose Sanz Lopez
                            |2024-2025
                        """.trimMargin()
                    )
                }
            }
        }
    }

}