package com.example.modularizedlibrary.profile

data class ProfileClass (
    val name: String
) {
    companion object {
        fun createProfileClass(): ProfileClass {
            return ProfileClass("Some profile class")
        }
    }
}