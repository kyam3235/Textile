package jp.kyamlab.textile.screen

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import jp.kyamlab.textile.getPlatform
import org.orbitmvi.orbit.ContainerHost
import org.orbitmvi.orbit.container

class GreetingViewModel : ContainerHost<GreetingState, GreetingSideEffect>, ViewModel() {
    private val showContent = mutableStateOf(false)

    override val container =
        viewModelScope.container<GreetingState, GreetingSideEffect>(
            GreetingState(
                showContent = showContent.value
            )
        )

    fun greet() = intent {
        postSideEffect(GreetingSideEffect.Toast("Welcome!"))

        reduce {
            showContent.value = !showContent.value
            state.copy(
                greeting = "Hello, ${getPlatform().name}",
                showContent = showContent.value
            )
        }
    }
}