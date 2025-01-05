package jp.kyamlab.textile.screen.login

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import jp.kyamlab.textile.view.PlatformWebView

@Composable
fun LoginScreen() {
    PlatformWebView(
        url = "https://www.google.com/",
        modifier = Modifier.fillMaxSize()
    )
}