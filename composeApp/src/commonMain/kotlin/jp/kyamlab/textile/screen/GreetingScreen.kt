package jp.kyamlab.textile.screen

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.Scaffold
import androidx.compose.material.SnackbarHost
import androidx.compose.material.SnackbarHostState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.resources.painterResource
import textile.composeapp.generated.resources.Res
import textile.composeapp.generated.resources.compose_multiplatform

@Composable
fun GreetingScreen(viewModel: GreetingViewModel) {
    val state = viewModel.container.stateFlow.collectAsState().value
    val snackbarHostState = remember { SnackbarHostState() }

    viewModel.container.sideEffectFlow.collectAsState(null).value?.let { sideEffect ->
        when (sideEffect) {
            is GreetingSideEffect.Toast -> {
                LaunchedEffect(sideEffect.text) {
                    snackbarHostState.showSnackbar(sideEffect.text)
                }
            }
        }
    }

    Scaffold(snackbarHost = { SnackbarHost(snackbarHostState) }) {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                viewModel.greet()
            }) {
                Text("Click me!")
            }
            AnimatedVisibility(state.showContent) {
                val greeting = remember { state.greeting }
                Column(
                    Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Image(painterResource(Res.drawable.compose_multiplatform), null)
                    Text("Compose: $greeting")
                }
            }
        }
    }
}