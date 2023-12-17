package ru.glebik.feature.home.internal.presentation

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

data class DetailScreen(val id: Int) : Screen {
    @Composable
    override fun Content() {
        Text(text = "Detail Screen id: $id")
    }
}