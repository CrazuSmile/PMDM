package com.juanjosesanz.dicegamejuanjosesanz

import android.os.Bundle
import android.service.notification.Condition
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonColors
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.juanjosesanz.dicegamejuanjosesanz.model.Dice
import com.juanjosesanz.dicegamejuanjosesanz.ui.theme.DiceGameJuanJoseSanzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DiceGameJuanJoseSanzTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DiceGame(modifier = Modifier.padding(innerPadding))
                }
            }
        }
    }
}

@Composable
fun DiceGame(modifier: Modifier) {
    var originalThrow by rememberSaveable { mutableIntStateOf(Dice.throwDiceNFaces(6)) }
    var newThrow by rememberSaveable { mutableIntStateOf(Dice.throwDiceNFaces(6)) }
    var points by rememberSaveable { mutableIntStateOf(20) }

    fun checkThrow(num: Int) {
        points -= 3
        if (newThrow == num) points += 15
        originalThrow = newThrow
        newThrow = Dice.throwDiceNFaces(6)
    }

    fun compareThrow(condition: (Int, Int) -> Boolean) {
        points -= 1
        if (condition(newThrow, originalThrow)) points += 3
        originalThrow = newThrow
        newThrow = Dice.throwDiceNFaces(6)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .then(modifier),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row {
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(id = R.string.title),
                    fontSize = 30.sp
                )
                Text(
                    text = stringResource(id = R.string.description1_1)
                )
                Text(
                    text = stringResource(id = R.string.description1_2)
                )
            }
        }
        Box(
            modifier = Modifier
                .padding(16.dp)
                .width(150.dp)
                .height(100.dp)
                .padding(4.dp)
                .background(colorResource(R.color.green))
                .border(2.dp, colorResource(R.color.black)),
            contentAlignment = Alignment.Center,

            ) {
            Text(
                text = stringResource(R.string.points, points),
                fontSize = 25.sp
            )
        }

        Spacer(modifier = Modifier.height(10.dp))
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Center
        ) {
            Box(
                modifier = Modifier
                    .padding(16.dp)
                    .width(150.dp)
                    .height(100.dp)
                    .padding(4.dp)
                    .background(colorResource(R.color.red))
                    .border(2.dp, colorResource(R.color.black)),
                contentAlignment = Alignment.Center,
                ) {
                Text(
                    text = stringResource(R.string.roll, originalThrow),
                    fontSize = 20.sp
                )
            }

            Spacer(modifier = Modifier.width(20.dp))
            Column(
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = stringResource(R.string.compare_pad)
                )
                Button(
                    onClick = {
                        compareThrow { newThrow, originalThrow -> newThrow < originalThrow }
                    },
                    enabled = points > 0,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(R.color.black),
                        containerColor = colorResource(R.color.blue)
                    )
                ) {
                    Text(
                        text = "<"
                    )
                }
                Button(
                    onClick = {
                        compareThrow { newThrow, originalThrow -> newThrow > originalThrow }
                    },
                    enabled = points > 0,
                    colors = ButtonDefaults.buttonColors(
                        contentColor = colorResource(R.color.black),
                        containerColor = colorResource(R.color.green)
                    )
                ) {
                    Text(
                        text = ">"
                    )
                }
            }

        }
        Spacer(modifier = Modifier.height(20.dp))
        Text(
            text = stringResource(R.string.numeric_pad)
        )
        Row {
            Button(
                onClick = {
                    checkThrow(1)
                },
                enabled = points > 0,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.gold)
                )
            ) {
                Text(
                    text = "1"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    checkThrow(2)
                },
                enabled = points > 0,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.gold)
                )
            ) {
                Text(
                    text = "2"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))
            Button(
                onClick = {
                    checkThrow(3)
                },
                enabled = points > 0,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.gold)
                )
            ) {
                Text(
                    text = "3"
                )
            }
        }
        Row {
            Button(
                onClick = {
                    checkThrow(4)
                },
                enabled = points > 0,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.gold)
                )
            ) {
                Text(
                    text = "4"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    checkThrow(5)
                },
                enabled = points > 0,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.gold)
                )
            ) {
                Text(
                    text = "5"
                )
            }
            Spacer(modifier = Modifier.width(10.dp))

            Button(
                onClick = {
                    checkThrow(6)
                },
                enabled = points > 0,
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.gold)
                )
            ) {
                Text(
                    text = "6"
                )
            }
        }
        if (points <= 0) {
            points = 0
            Text(
                text = stringResource(R.string.game_over),
                fontSize = 30.sp

            )
            Button(
                onClick = {
                    points = 20
                },
                colors = ButtonDefaults.buttonColors(
                    contentColor = colorResource(R.color.black),
                    containerColor = colorResource(R.color.red)
                )
            ) {
                Text(
                    text = stringResource(R.string.try_agian)
                )
            }
        }
    }

}

