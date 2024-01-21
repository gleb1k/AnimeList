package ru.glebik.feature.search.internal.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.widget.BaseAsyncImage
import ru.glebik.core.widget.BaseSurface
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchScreenModel
import ru.glebik.feature.search.internal.presentation.viewmodel.SearchStore
import ru.glebik.feature.search.internal.widget.SearchAppBar

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
            navigator,
            onQuerySearchChange = viewModel::onQuerySearchChange,
            onSearchClick = viewModel::onSearchClick,
            onItemClick = viewModel::navigateToDetails
        )
    }

    @Composable
    private fun SearchView(
        state: SearchStore.State,
        navigator: Navigator,
        onQuerySearchChange: (String) -> Unit,
        onSearchClick: (String) -> Unit,
        onItemClick: (Int) -> Unit
    ) {
        BaseSurface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                SearchAppBar(
                    navigator = navigator,
                    searchValue = state.querySearch,
                    onQuerySearchChange = onQuerySearchChange,
                    onSearchClick = onSearchClick,
                )

                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(
                        vertical = AppTheme.padding.verticalMedium,
                    ),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.padding.verticalMedium),
                ) {
                    items(state.searchList) {
                        AnimeItem(item = it, onClick = onItemClick)
                    }
                }
            }
        }
    }

    @Composable
    private fun AnimeItem(
        item: AnimeBaseModel,
        onClick: (Int) -> Unit,
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onClick.invoke(item.malId)
                }
                .padding(horizontal = 8.dp)
                .background(AppTheme.colors.background),

            verticalAlignment = Alignment.CenterVertically
        ) {
            BaseAsyncImage(
                data = item.image,
                modifier = Modifier
                    .height(150.dp)
                    .width(100.dp)
            )
            Column(
                modifier = Modifier
                    .padding(start = 8.dp)
            ) {
                Text(
                    text = item.title ?: item.titleEnglish ?: "-",
                    style = AppTheme.typography.bodyBold
                )
                if (item.score != 0.0)
                    Text(
                        text = "Score: ${item.score}",
                        style = AppTheme.typography.bodyBold
                    )
            }
        }
        ItemDivider()
    }

    @Composable
    private fun ItemDivider() {
        Divider(
            modifier = Modifier.padding(1.dp),
            thickness = 0.5.dp,
            color = AppTheme.colors.tint
        )
    }
}

