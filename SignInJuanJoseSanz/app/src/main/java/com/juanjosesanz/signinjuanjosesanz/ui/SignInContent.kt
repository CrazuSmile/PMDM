package com.juanjosesanz.signinjuanjosesanz.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.juanjosesanz.signinjuanjosesanz.ui.screens.SignIn
import com.juanjosesanz.signinjuanjosesanz.ui.theme.SignInEnhancedTheme

@Composable
fun SignInContent(content: @Composable (modifier: Modifier) -> Unit) {
    SignInEnhancedTheme {
        Scaffold(
            modifier = Modifier.fillMaxSize()
        ) { innerPadding ->
            content(Modifier.padding(innerPadding))
        }
    }
}