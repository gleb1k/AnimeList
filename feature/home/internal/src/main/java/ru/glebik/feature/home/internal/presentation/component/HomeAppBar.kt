package ru.glebik.feature.home.internal.presentation.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.navigator.Navigator
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.navigation.SharedScreen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeAppBar(
    navigator: Navigator,
) {
    val searchScreen = rememberScreen(SharedScreen.Search)
    val profileScreen = rememberScreen(SharedScreen.Profile)

    TopAppBar(
        title = {
            Text(
                "AnimeList",
                style = AppTheme.typography.topBar
            )
        },
        actions = {
            IconButton(onClick = {
                if (navigator.lastItem != searchScreen) navigator.push(
                    searchScreen
                )
            }) {
                Icon(
                    imageVector = Icons.Filled.Search,
                    contentDescription = "Search"
                )
            }
            IconButton(onClick = {
                if (navigator.lastItem != profileScreen) navigator.push(
                    profileScreen
                )
            }) {
                Icon(
                    imageVector = Icons.Filled.Person,
                    contentDescription = "Profile"
                )
            }

        }
    )
}