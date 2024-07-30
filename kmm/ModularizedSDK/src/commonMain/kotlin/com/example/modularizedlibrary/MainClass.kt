package com.example.modularizedlibrary

data class MainClass (
    val name: String,
) {
    fun greet(): String {
        return "Hello, $name!"
    }

    companion object {
        fun create(): MainClass {
            return MainClass("John Doe")
        }
    }
}