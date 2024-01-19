package ru.glebik.feature.search.internal.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchScreenModel
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchStore

object SearchScreen : Screen {
    private fun readResolve(): Any = SearchScreen

    @Composable
    override fun Content() {
        SearchScreen()
    }

    @Composable
    private fun SearchScreen(
        viewModel: SearchScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()
        val label by viewModel.label.collectAsStateWithLifecycle(initialValue = null)

        when (label) {
            null -> Unit
            is SearchStore.Label.NavigateToDetails -> {
                navigator.push(rememberScreen(SharedScreen.Detail(id = (label as SearchStore.Label.NavigateToDetails).id)))
            }
        }

        SearchView(
            state,
            navigator::pop
        )
    }

    @Composable
    private fun SearchView(
        state: SearchStore.State,
        onBackClick: () -> Unit,
    ) {

    }
}
