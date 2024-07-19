import coremodule.Placeholder

data class UserProfile (
    val name: String,
    val age: Int
) {
    val placeholder = Placeholder()

    fun greet(): String {
        return "Hello, ${name} in ${placeholder.platform}!"
    }
}