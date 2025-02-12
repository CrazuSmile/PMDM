package com.juanjosesanz.taskmanager.navigation

import kotlinx.serialization.Serializable

sealed class Routes {
    @Serializable
    object Splash

    @Serializable
    object Main

    @Serializable
    object OnBoarding

    @Serializable
    data class TaskInfo (
        val id: Int
    )
}



