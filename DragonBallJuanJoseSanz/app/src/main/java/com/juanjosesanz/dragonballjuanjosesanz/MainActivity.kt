package com.juanjosesanz.dragonballjuanjosesanz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.juanjosesanz.dragonballjuanjosesanz.ui.DragonBallContent
import com.juanjosesanz.dragonballjuanjosesanz.ui.screens.DragonBall
import com.juanjosesanz.dragonballjuanjosesanz.ui.theme.DragonBallJuanJoseSanzTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            DragonBallContent {
                DragonBall()
            }
        }
    }
}

