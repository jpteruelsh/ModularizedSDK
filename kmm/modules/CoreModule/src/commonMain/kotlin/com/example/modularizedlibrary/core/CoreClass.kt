package coremodule.com.example.modularizedlibrary.core

data class CoreClass (
    val name: String
) {
    companion object {
        fun createCoreClass(): CoreClass {
            return CoreClass("Some core class")
        }
    }
}