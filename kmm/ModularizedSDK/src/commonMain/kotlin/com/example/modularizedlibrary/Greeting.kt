package com.example.modularizedlibrary

import com.example.modularizedlibrary.profile.UserProfile
import kotlin.js.JsExport

@JsExport
class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        val profile = UserProfile(
            name = "John Doe",
            age = 30
        )
        return profile.greet()
    }
}