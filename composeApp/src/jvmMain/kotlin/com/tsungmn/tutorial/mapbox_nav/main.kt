package com.tsungmn.tutorial.mapbox_nav

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "MapboxNavTutorial",
    ) {
        App()
    }
}