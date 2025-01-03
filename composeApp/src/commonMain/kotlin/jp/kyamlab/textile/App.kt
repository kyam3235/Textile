package jp.kyamlab.textile

import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import jp.kyamlab.textile.di.dataModule
import jp.kyamlab.textile.di.viewModelModule
import jp.kyamlab.textile.screen.GreetingScreen
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinApplication
import org.koin.compose.viewmodel.koinViewModel

@Composable
@Preview
fun App() {
    KoinApplication(application = {
        modules(
            dataModule,
            viewModelModule
        )
    }) {
        MaterialTheme {
            GreetingScreen(koinViewModel())
        }
    }
}