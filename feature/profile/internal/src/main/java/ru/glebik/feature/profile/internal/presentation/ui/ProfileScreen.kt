package ru.glebik.feature.profile.internal.presentation.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Divider
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.widget.BackAppBar
import ru.glebik.core.widget.screen.NotAuthorizedView
import ru.glebik.feature.profile.internal.R
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileScreenModel
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileStore

object ProfileScreen : Screen {

    private fun readResolve(): Any = ProfileScreen

    @Composable
    override fun Content() {
        ProfileScreen()
    }

    @Composable
    private fun ProfileScreen(
        viewModel: ProfileScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()

        val signInScreen = rememberScreen(SharedScreen.SignIn)
        val signUpScreen = rememberScreen(SharedScreen.SignUp)

        LaunchedEffect(key1 = Unit) {
            viewModel.checkIsAuth()

            if (state.isAuth)
                viewModel.loadUserData()
        }

        if (!state.isAuth) {
            NotAuthorizedView(
                { navigator.push(signInScreen) },
                { navigator.push(signUpScreen) },
                navigator::pop
            )
        } else {
            ProfileView(
                state,
                navigator::pop
            )
        }
    }

    @Composable
    private fun ProfileView(
        state: ProfileStore.State,
        onBackClick: () -> Unit,
    ) {
        //    var selectedTabIndex by remember {
//        mutableStateOf(0)
//    }
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BackAppBar(onBackClick)
            Header()
            Spacer(modifier = Modifier.height(16.dp))
            Stats(state.userData?.name ?: "")
            Spacer(modifier = Modifier.height(16.dp))
//        FeedComponent() {
//            selectedTabIndex = it
//        }
//        when (selectedTabIndex) {
//            0 -> PostsComponent(
//                posts_list = posts_list,
//                modifier = Modifier.fillMaxWidth()
//            )
//            1 -> PostsComponent(
//                posts_list = tag_posts_list,
//                modifier = Modifier.fillMaxWidth()
//            )
//        }
        }
    }

    @Composable
    fun Header() {
        Column(
            modifier = Modifier
                .fillMaxWidth()
        ) {
            Box(
                modifier = Modifier
                    .height(200.dp)
                    .fillMaxWidth()
            ) {
                Box(
                    modifier = Modifier
                        .height(140.dp)
                        .fillMaxWidth()
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.frieren_cover),
                        contentDescription = "",
                        modifier = Modifier.fillMaxSize(),
                        contentScale = ContentScale.Crop,
                    )
                    Box(
                        modifier = Modifier
                            .height(90.dp)
                            .fillMaxWidth()
                            .background(
                                Brush.verticalGradient(
                                    listOf(
                                        Color.Transparent, Color.Black
                                    )
                                )
                            )
                            .align(Alignment.BottomStart)
                    )
                }

                ProfileImage(
                    contentDescription = null,
                    modifier = Modifier
                        .size(125.dp)
                        .align(Alignment.BottomCenter)
                )
            }
        }

    }


    @Composable
    fun ProfileImage(
        contentDescription: String?, modifier: Modifier = Modifier, elevation: Dp = 0.dp
    ) {
        Surface(
            color = Color(0xFF17181F),
            shape = RoundedCornerShape(40.dp),
            modifier = modifier,
            border = BorderStroke(
                3.dp, Brush.linearGradient(
                    listOf(
                        Color(0xFFbc2a8d), Color(0xFF8a3ab9)
                    )
                )
            )
        ) {
            Image(
                painter = painterResource(id = R.drawable.frieren),
                contentDescription = contentDescription,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(10.dp)
                    .clip(shape = RoundedCornerShape(40.dp)),
                contentScale = ContentScale.Crop,
            )
        }
    }


    @Composable
    fun Stats(
        username: String,
    ) {
        Column(
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(
                text = username,
                style = AppTheme.typography.body,
                color = Color.DarkGray,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            )
            Spacer(Modifier.height(16.dp))
            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center,
            ) {
                Divider(
                    modifier = Modifier
                        .height(40.dp)
                        .width(1.dp)
                        .padding(top = 2.dp, bottom = 2.dp), color = Color.LightGray
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "-1", style = AppTheme.typography.body, color = Color.DarkGray
                    )
                    Text(
                        text = "Animes",
                        style = AppTheme.typography.body,
                        color = Color.LightGray
                    )
                }
                Spacer(modifier = Modifier.width(16.dp))
                Divider(
                    modifier = Modifier
                        .height(40.dp)
                        .width(1.dp)
                        .padding(top = 2.dp, bottom = 2.dp), color = Color.LightGray
                )
            }
        }
    }
}

//
//@Composable
//fun FeedComponent(
//    modifier: Modifier = Modifier,
//    onTabSelected: (selectedIndex: Int) -> Unit
//) {
//    var selectedIndex by remember {
//        mutableStateOf(0)
//    }
//    val imageWithText = listOf(
//        ImageWithText(
//            image = painterResource(id = R.drawable.ic_grid),
//            text = "Posts"
//        ),
//        ImageWithText(
//            image = painterResource(id = R.drawable.ic_instagram_tag),
//            text = "Tags"
//        )
//    )
//    val inactiveColor = Color(0xFF777777)
//    TabRow(
//        selectedTabIndex = selectedIndex,
//        backgroundColor = Color.Transparent,
//        contentColor = Color.Black,
//        modifier = modifier
//    ) {
//        imageWithText.forEachIndexed { index, item ->
//            Tab(
//                selected = selectedIndex == index,
//                selectedContentColor = Color.Black,
//                unselectedContentColor = inactiveColor,
//                onClick = {
//                    selectedIndex = index
//                    onTabSelected(index)
//                }
//            ) {
//                Icon(
//                    painter = item.image,
//                    contentDescription = item.text,
//                    tint = if (selectedIndex == index) Color.Black else inactiveColor,
//                    modifier = Modifier
//                        .padding(18.dp)
//                        .size(20.dp)
//                )
//            }
//        }
//    }
//}
//
//
//@ExperimentalFoundationApi
//@Composable
//fun PostsComponent(
//    posts_list: List<Posts>,
//    modifier: Modifier = Modifier
//) {
//    LazyVerticalGrid(
//        cells = GridCells.Fixed(3),
//        modifier = Modifier.scale(1.01f)
//    ) {
//        items(posts_list.size) {
//            Image(
//                painter = rememberImagePainter(
//                    data = posts_list[it].imageUrl,
//                    builder = {
//                        crossfade(true)
//                        placeholder(drawableResId = R.drawable.gojo)
//                        scale(Scale.FILL)
//                    }
//                ),
//                contentDescription = posts_list[it].text,
//                contentScale = ContentScale.Crop,
//                modifier = Modifier
//                    .aspectRatio(1f)
//                    .border(
//                        width = 1.dp,
//                        color = Color.White
//                    )
//            )
//        }
//    }
//}
