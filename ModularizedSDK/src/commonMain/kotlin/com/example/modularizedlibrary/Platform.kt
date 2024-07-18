package com.example.modularizedlibrary

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform