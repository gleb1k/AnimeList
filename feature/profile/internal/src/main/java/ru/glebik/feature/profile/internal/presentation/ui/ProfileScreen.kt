package ru.glebik.feature.profile.internal.presentation.ui

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.glebik.feature.profile.internal.presentation.viewmodel.MviProfileScreenModel
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileStore

object ProfileScreen : Screen {
    private fun readResolve(): Any = ProfileScreen

    @Composable
    override fun Content() {
        ProfileScreen()
    }

    @Composable
    private fun ProfileScreen(
        viewModel: MviProfileScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()

        ProfileView(
            state
        )
    }

    @Composable
    private fun ProfileView(
        state: ProfileStore.State,
    ) {
        Text(text = "ProfileScreen")
    }
}