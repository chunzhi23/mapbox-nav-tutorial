package com.tsungmn.tutorial.mapbox_nav

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform