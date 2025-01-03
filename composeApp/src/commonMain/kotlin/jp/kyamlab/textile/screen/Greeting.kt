package jp.kyamlab.textile.screen

data class GreetingState(
    val showContent: Boolean,
    val greeting: String = "",
)

sealed class GreetingSideEffect {
    data class Toast(val text: String) : GreetingSideEffect()
}