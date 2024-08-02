package com.example.modularizedlibrary.profile

import kotlin.js.JsExport

@JsExport
data class ProfileClass (
    val name: String
) {
    companion object {
        fun createProfileClass(): ProfileClass {
            return ProfileClass("Some profile class")
        }
    }
}