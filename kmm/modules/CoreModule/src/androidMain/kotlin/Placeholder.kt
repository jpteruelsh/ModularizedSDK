package coremodule

actual class Placeholder actual constructor() {
    actual val platform: String = "Android ${android.os.Build.VERSION.SDK_INT}"
}