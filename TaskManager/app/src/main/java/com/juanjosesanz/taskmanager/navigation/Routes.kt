package com.juanjosesanz.taskmanager.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object Splash

    @Serializable
    object Main
}



