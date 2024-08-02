package coremodule.com.example.modularizedlibrary.core

data class CoreClass (
    val name: String
) {
    fun greet(): String {
        return "Hello, ${name}! Welcome to the core module!"
    }
    
    companion object {
        fun createCoreClass(): CoreClass {
            return CoreClass("Some core class")
        }
    }
}