package ru.glebik.feature.search.internal

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.screen.Screen

object SearchScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "Search Screen")
    }

}