package com.example.modularizedlibrary

import kotlin.test.Test
import kotlin.test.assertTrue

class CommonGreetingTest {

    @Test
    fun testExample() {
        // given
        val greeting = Greeting()

        // when
        val result = greeting.greet()

        // then
        assertTrue(result.contains("John Doe"), "Check 'John Doe' is mentioned")
        println("CommonGreetingTest: $result")
    }
}