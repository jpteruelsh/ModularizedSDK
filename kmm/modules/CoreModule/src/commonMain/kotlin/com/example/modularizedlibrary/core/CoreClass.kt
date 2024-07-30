package coremodule.com.example.modularizedlibrary.core

data class CoreClass (
    val name: String
) {
    fun greet(): String {
        return "Hello, ${name}!"
    }
    
    companion object {
        fun createCoreClass(): CoreClass {
            return CoreClass("Some core class")
        }
    }
}