package com.juanjosesanz.satisticsjuanjose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanjosesanz.satisticsjuanjose.ui.theme.SatisticsJuanJoseTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            SatisticsJuanJoseTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Counters(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun Counters(modifier: Modifier) {
    var total by rememberSaveable { mutableIntStateOf(0) }
    var person by rememberSaveable { mutableIntStateOf(0) }
    var bicycle by rememberSaveable { mutableIntStateOf(0) }
    var scooter by rememberSaveable { mutableIntStateOf(0) }
    var car by rememberSaveable { mutableIntStateOf(0) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Estadisticas Juan Jose",
            fontSize = 30.sp
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row {
            Column {
                Text(
                    text = "Total: $total",
                    fontSize = 23.sp
                )
                Spacer(modifier = Modifier.height(15.dp))
                Button(
                    onClick = {
                        total = 0
                        person = 0
                        bicycle = 0
                    }
                ) {
                    Text(
                        text = "Reiniciar"
                    )
                }
            }
            Spacer(modifier = Modifier.width(15.dp))
            Column {
                Text(
                    text = "Estadisticas: ",
                    fontSize = 23.sp
                )
                Text(
                    text = """|Personas: 0
                        |Bicicletas: 0
                        |Patienetes: 0
                        |Coches: 0""".trimMargin()
                )
            }
        }
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Personas: $person",
                    fontSize = 23.sp
                )
                Column {
                    Row {
                        Button(
                            onClick = {
                                person++
                                total++
                            }
                        ) {
                            Text(
                                text = "+1"
                            )
                        }
                        Button(
                            onClick = {
                                if (person > 0) {
                                    person -= 1
                                    if (total > 0) total -= 1
                                }
                            }
                        ) {
                            Text(
                                text = "-1"
                            )
                        }
                    }
                }
                Column {
                    Row {
                        Button(
                            onClick = {
                                total -= person
                                person = 0
                            }
                        ) {
                            Text(
                                text = "Reset"
                            )
                        }
                    }
                }


            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Bicicletas: $bicycle",
                    fontSize = 23.sp
                )
                Column {
                    Row {
                        Button(
                            onClick = {
                                bicycle++
                                total++
                            }
                        ) {
                            Text(
                                text = "+1"
                            )
                        }
                        Button(
                            onClick = {
                                if (bicycle > 0) {
                                    bicycle -= 1
                                    if (total > 0) total -= 1
                                }
                            }
                        ) {
                            Text(
                                text = "-1"
                            )
                        }
                    }
                }
                Column {
                    Row {
                        Button(
                            onClick = {
                                total -= bicycle
                                bicycle = 0
                            }
                        ) {
                            Text(
                                text = "Reset"
                            )
                        }
                    }
                }


            }
        }
        Spacer(modifier = Modifier.height(15.dp))
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Patinetes: 0",
                    fontSize = 23.sp
                )
                Column {
                    Row {
                        Button(
                            onClick = {
                                scooter++
                                total++
                            }
                        ) {
                            Text(
                                text = "+1"
                            )
                        }
                        Button(
                            onClick = {
                                if (scooter > 0) {
                                    scooter -= 1
                                    if (total > 0) total -= 1
                                }
                            }
                        ) {
                            Text(
                                text = "-1"
                            )
                        }
                    }
                }
                Column {
                    Row {
                        Button(
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "Reset"
                            )
                        }
                    }
                }


            }
            Spacer(modifier = Modifier.width(15.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                Text(
                    text = "Coches: 0",
                    fontSize = 23.sp
                )
                Column {
                    Row {
                        Button(
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "+1"
                            )
                        }
                        Button(
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "-1"
                            )
                        }
                    }
                }
                Column {
                    Row {
                        Button(
                            onClick = {

                            }
                        ) {
                            Text(
                                text = "Reset"
                            )
                        }
                    }
                }


            }
        }

    }
}