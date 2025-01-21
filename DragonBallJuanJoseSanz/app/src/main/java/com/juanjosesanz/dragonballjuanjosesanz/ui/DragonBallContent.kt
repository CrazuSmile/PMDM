package com.juanjosesanz.dragonballjuanjosesanz.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import com.juanjosesanz.dragonballjuanjosesanz.ui.theme.DragonBallJuanJoseSanzTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DragonBallContent(content: @Composable () -> Unit) {

    DragonBallJuanJoseSanzTheme {
        content()
    }
}