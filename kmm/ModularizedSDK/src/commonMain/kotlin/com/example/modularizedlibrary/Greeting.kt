package com.example.modularizedlibrary

import UserProfile

class Greeting {
    private val platform: Platform = getPlatform()

    fun greet(): String {
        return "Hello world!!!";
//        val profile = UserProfile(
//            name = "John Doe",
//            age = 30
//        )
//        return profile.greet()
    }
}