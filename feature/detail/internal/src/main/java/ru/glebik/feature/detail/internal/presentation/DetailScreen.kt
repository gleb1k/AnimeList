package ru.glebik.feature.detail.internal.presentation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.widget.BackAppBar
import ru.glebik.core.widget.BaseAsyncImage
import ru.glebik.core.widget.BaseSurface
import ru.glebik.core.widget.template.DetailScreenModel
import ru.glebik.feature.detail.internal.R
import ru.glebik.feature.detail.internal.presentation.viewmodel.DetailStore


data class DetailScreen(
    val id: Int
) : Screen {

    @Composable
    override fun Content() {
        DetailScreen2()
    }

    @Composable
    private fun DetailScreen2(
        viewModel: DetailScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()
        val label by viewModel.label.collectAsStateWithLifecycle(initialValue = null)

        LaunchedEffect(key1 = state.anime) {
            viewModel.load(id)
        }

        DetailView(
            state = state,
            navigator::pop,
        )
    }


    @Composable
    private fun DetailView(
        state: DetailStore.State,
        onBackClick: () -> Unit,
    ) {
        BaseSurface {
            Column(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                BackAppBar(onBackClick)

//                Box(
//                    modifier = Modifier
//                        .offset(x = 100.dp, y = 100.dp),
//
//                ) {
//                    FloatingActionButton(
//                        onClick = { },
//                    ) {
//                        Icon(Icons.Filled.Add, "Floating action button.")
//                    }
//                }

                val scrollState = rememberScrollState()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .verticalScroll(scrollState),
                )
                {
                    AnimeItemWithDesc(state = state)
                }
            }
        }
    }

    @Composable
    fun AnimeItemWithDesc(state: DetailStore.State) {
        val item = state.anime

        if (item != null) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                modifier = Modifier
                    .fillMaxSize(),
            ) {
                Box(
                    modifier = Modifier
                        .height(320.dp)
                        .width(180.dp)
                        .clip(RoundedCornerShape(2.dp))
                ) {
                    BaseAsyncImage(data = item.image)
                }
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier
                        .fillMaxSize()
                        .clip(RoundedCornerShape(topEnd = 16.dp, topStart = 16.dp))
                        .background(AppTheme.colors.background)
                ) {
                    Spacer(modifier = Modifier.padding(vertical = 8.dp))
                    Text(
                        text = state.anime.titleEnglish ?: "",
                        color = AppTheme.colors.primary,
                        style = AppTheme.typography.bodyBold,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
//                    Text(
//                        text = state.anime.title ?: "",
//                        color = AppTheme.colors.primary,
//                        style = AppTheme.typography.body,
//                        modifier = Modifier
//                            .padding(horizontal = 8.dp)
//                            .padding(bottom = 8.dp)
//                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .padding(bottom = 16.dp)
                    ) {
//                            Text(
//                                text = "${state.anime.year} y.",
//                                color = AppTheme.colors.primary,
//                                style = AppTheme.typography.body,
//                                modifier = Modifier
//                                    .padding(horizontal = 8.dp),
//                            )
                        Text(
                            text = state.anime.type ?: "",
                            color = AppTheme.colors.primary,
                            style = AppTheme.typography.body,
                            modifier = Modifier
                                .padding(horizontal = 8.dp),
                        )
                        Text(
                            text = state.anime.score.toString(),
                            color = AppTheme.colors.primary,
                            style = AppTheme.typography.body,
                            modifier = Modifier
                                .padding(horizontal = 8.dp),
                        )
                    }

                    InfoDivider()
                    InfoText(
                        title = stringResource(R.string.rating),
                        text = state.anime.rating ?: "0.0"
                    )
                    InfoDivider()
                    if (state.anime.airing == true)
                        InfoText(
                            title = stringResource(R.string.status),
                            text = "Ongoing"
                        )
                    else if (state.anime.airing == false)
                        InfoText(
                            title = stringResource(R.string.status),
                            text = "Finished"
                        )
                    InfoDivider()
                    InfoText(
                        title = stringResource(R.string.episodes),
                        text = state.anime.episodes.toString()
                    )
                    InfoDivider()
                    InfoText(
                        title = stringResource(R.string.source),
                        text = state.anime.source ?: ""
                    )
                    InfoDivider()
                    InfoText(
                        title = stringResource(R.string.studio),
                        text = "-"
                    )
                    InfoDivider()
                    Spacer(modifier = Modifier.padding(8.dp))
                    Text(
                        text = state.anime.synopsis ?: "",
                        color = AppTheme.colors.primary,
                        style = AppTheme.typography.body,
                        modifier = Modifier
                            .padding(horizontal = 8.dp)
                    )
                }
            }

        }

    }

    @Composable
    private fun InfoText(title: String, text: String) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.Start,
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Text(
                text = title,
                color = AppTheme.colors.primary,
                style = AppTheme.typography.body,
                modifier = Modifier
                    .padding(start = 8.dp)
                    .weight(2f),
            )
            Text(
                text = text,
                color = AppTheme.colors.primary,
                style = AppTheme.typography.body,
                modifier = Modifier
                    .weight(3f),
            )
        }
    }

    @Composable
    private fun InfoDivider() {
        Divider(
            modifier = Modifier.padding(1.dp),
            thickness = 0.5.dp,
            color = AppTheme.colors.tint
        )
    }


}