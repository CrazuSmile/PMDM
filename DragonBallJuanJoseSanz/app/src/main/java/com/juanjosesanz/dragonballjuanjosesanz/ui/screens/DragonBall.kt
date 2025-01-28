package com.juanjosesanz.dragonballjuanjosesanz.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.ExperimentalMaterial3Api
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
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.juanjosesanz.dragonballjuanjosesanz.R
import com.juanjosesanz.dragonballjuanjosesanz.model.DragonBallCharacter

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DragonBall() {
    val orange = Color(0xFFF89F02)
    val green = Color(0xFF8BC34A)
    val lightOrange = Color(0xFFFFBB56)
    val dragonBallCharacter = DragonBallCharacter


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
        Row(
            modifier = Modifier
                .fillMaxSize()
                .background(lightOrange)
                .padding(innerPadding)
        ) {
            Box() {
                LazyColumn {
                    val groupCharacter = Map<Char, List<String>> = dragonBallCharacter.sorted().groupBy{it:[0]}
                }
                if (boxState) {
                    Box(
                        modifier = Modifier.fillMaxSize(),
                        contentAlignment = Alignment.Center,
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically,
                            horizontalArrangement = Arrangement.Center,
                        ) {
                            Image(
                                painter = painterResource(R.drawable.author),
                                contentDescription = "Author",
                                modifier = Modifier
                                    .size(200.dp)
                                    .graphicsLayer(rotationZ = 90f),
                                contentScale = ContentScale.Fit
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
    }
}