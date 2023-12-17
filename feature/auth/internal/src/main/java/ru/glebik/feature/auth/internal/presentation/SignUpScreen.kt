package ru.glebik.feature.auth.internal.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object SignUpScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "SingUp Screen")
    }

}