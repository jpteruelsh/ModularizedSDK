import coremodule.Platform

data class UserProfile (
    val name: String,
    val age: Int
) {
    val platform: Platform = Platform()

    fun greet(): String {
        return "Hello, ${name} in ${platform.platform}!"
    }
}