package ru.glebik.feature.home.internal.presentation.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.SubcomposeAsyncImage
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeStore
import ru.glebik.feature.home.internal.presentation.viewmodel.MviHomeScreenModel

object HomeScreen : Screen {
    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        HomeScreen()
    }

    @Composable
    private fun HomeScreen(
        viewModel: MviHomeScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()
        val label by viewModel.label.collectAsStateWithLifecycle(initialValue = null)

        when (label) {
            null -> Unit
            is HomeStore.Label.NavigateToDetails -> {}
        }

        HomeView(
            state = state,
            onRecommendationClick = viewModel::navigate
        )
    }

    @Composable
    private fun HomeView(
        state: HomeStore.State,
        onRecommendationClick: (Int) -> Unit
    ) {
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .background(color = AppTheme.colors.surface),
            contentPadding = PaddingValues(
                vertical = AppTheme.padding.verticalLarge,
            ),
            verticalArrangement = Arrangement.spacedBy(AppTheme.padding.verticalLarge),

            ) {
            item {
                TextTitleItem(title = "Новое")
            }
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = AppTheme.padding.horizontalLarge),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.padding.horizontalBig),
                ) {
                    items(
                        state.recommendations,
                        key = {
                            it.malId
                        },
                    ) {
                        AnimeRecommendationItem(item = it, onRecommendationClick)
                    }
                }
            }
            item {
                TextTitleItem(title = "Недавнее")
            }
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = AppTheme.padding.horizontalLarge),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.padding.horizontalBig),
                ) {
                    items(
                        state.recommendations,
                        key = {
                            it.malId
                        },
                    ) {
                        AnimeRecommendationItem(item = it, onRecommendationClick)
                    }
                }
            }
            item {
                TextTitleItem(title = "Недавнее")
            }
            item {
                LazyRow(
                    contentPadding = PaddingValues(horizontal = AppTheme.padding.horizontalLarge),
                    horizontalArrangement = Arrangement.spacedBy(AppTheme.padding.horizontalBig),
                ) {
                    items(
                        state.recommendations,
                        key = {
                            it.malId
                        },
                    ) {
                        AnimeRecommendationItem(item = it, onRecommendationClick)
                    }
                }
            }
        }

    }

    @Composable
    private fun TextTitleItem(
        title: String
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.Bottom,
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = AppTheme.padding.horizontalLarge),
        ) {
            Text(
                text = title,
                style = AppTheme.typography.subHeader,
            )
            Text(
                text = "Все",
                style = AppTheme.typography.bodyBold,
            )
        }
    }

    @Composable
    private fun AnimeRecommendationItem(
        item: AnimeRecommendation,
        navigate: (Int) -> Unit
    ) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
//                .height(150.dp)
                .clickable { navigate.invoke(item.malId) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f)
            ) {
                SubcomposeAsyncImage(
                    model = item.image,
                    loading = {
                        CircularProgressIndicator(
                            modifier = Modifier.size(20.dp)
                        )
                    },
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()

                )
                Text(
                    text = "0.0",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(Color.Green)
                )
            }
            Text(
                text = item.title,
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
