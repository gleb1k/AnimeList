package ru.glebik.feature.home.internal.presentation

import android.util.Log
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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import cafe.adriel.voyager.navigator.currentOrThrow
import coil.compose.AsyncImage
import coil.request.ImageRequest
import kotlinx.coroutines.Dispatchers
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.widget.BaseSurface
import ru.glebik.core.widget.R
import ru.glebik.core.widget.screen.LoadingView
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.home.internal.presentation.component.HomeAppBar
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeScreenModel
import ru.glebik.feature.home.internal.presentation.viewmodel.HomeStore

object HomeScreen : Screen {
    private fun readResolve(): Any = HomeScreen

    @Composable
    override fun Content() {
        HomeScreen()
    }

    @Composable
    private fun HomeScreen(
        viewModel: HomeScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()
        val label by viewModel.label.collectAsStateWithLifecycle(initialValue = null)

        //TODO 3 раза вызывается почему-то, хз как фиксить
        when (label) {
            null -> Unit
            is HomeStore.Label.NavigateToDetails -> {
                Log.e("HomeStore.Label.NavigateToDetails", "navigated to detail")
                val detailScreen =
                    rememberScreen(SharedScreen.Detail(id = (label as HomeStore.Label.NavigateToDetails).id))
                navigator.push(detailScreen)
            }
        }

        if (state.isLoading)
            LoadingView()
        else
            HomeView(
                state = state,
                navigator,
                onItemClick = viewModel::navigateToDetail
            )
    }

    @Composable
    private fun HomeView(
        state: HomeStore.State,
        navigator: Navigator,
        onItemClick: (Int) -> Unit,
    ) {
        BaseSurface {
            Column(
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                HomeAppBar(navigator = navigator)
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize(),
                    contentPadding = PaddingValues(
                        vertical = AppTheme.padding.verticalLarge,
                    ),
                    verticalArrangement = Arrangement.spacedBy(AppTheme.padding.verticalLarge),

                    ) {
                    item {
                        TextTitleItem(title = "This Season Anime")
                    }
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = AppTheme.padding.horizontalLargeBase),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.padding.horizontalBig),
                        ) {
                            items(
                                state.seasonNow,
                                key = {
                                    it.malId
                                },
                            ) {
                                AnimeItem(item = it, onItemClick)
                            }
                        }
                    }
                    item {
                        TextTitleItem(title = "Top Anime by Score")
                    }
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = AppTheme.padding.horizontalLargeBase),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.padding.horizontalBig),
                        ) {
                            items(
                                state.topByScore,
                                key = {
                                    it.malId
                                },
                            ) {
                                AnimeItem(item = it, onItemClick)
                            }
                        }
                    }
                    item {
                        TextTitleItem(title = "Recommendations")
                    }
                    item {
                        LazyRow(
                            contentPadding = PaddingValues(horizontal = AppTheme.padding.horizontalLargeBase),
                            horizontalArrangement = Arrangement.spacedBy(AppTheme.padding.horizontalBig),
                        ) {
                            items(
                                state.recommendations,
                                key = {
                                    it.malId
                                },
                            ) {
                                AnimeRecommendationItem(item = it, onItemClick)
                            }
                        }
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
                .padding(horizontal = AppTheme.padding.horizontalLargeBase),
        ) {
            Text(
                text = title,
                style = AppTheme.typography.subHeader,
            )
            Text(
                text = "All",
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
                .clickable { navigate(item.malId) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.image)
                        .crossfade(true)
                        .dispatcher(Dispatchers.IO)
                        .build(),
                    placeholder = painterResource(id = R.drawable.placeholder),
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
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

    @Composable
    private fun AnimeItem(
        item: AnimeBaseModel,
        navigate: (Int) -> Unit
    ) {
        Column(
            modifier = Modifier
                .width(120.dp)
                .clip(RoundedCornerShape(topEnd = 8.dp, topStart = 8.dp))
                .clickable { navigate(item.malId) }
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .aspectRatio(0.75f)
            ) {
                AsyncImage(
                    model = ImageRequest.Builder(LocalContext.current)
                        .data(item.image)
                        .crossfade(true)
                        .dispatcher(Dispatchers.IO)
                        .build(),
                    placeholder = painterResource(id = R.drawable.placeholder),
                    contentDescription = item.title,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxWidth()
                )
                Text(
                    text = "${item.score ?: "0.0"}",
                    color = Color.Black,
                    modifier = Modifier
                        .align(Alignment.TopEnd)
                        .padding(4.dp)
                        .background(Color.Green)
                )
            }
            Text(
                text = item.titleEnglish ?: item.title ?: "-",
                overflow = TextOverflow.Ellipsis,
                maxLines = 1,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
