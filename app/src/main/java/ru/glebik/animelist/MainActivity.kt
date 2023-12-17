package ru.glebik.animelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.CurrentScreen
import cafe.adriel.voyager.navigator.Navigator
import ru.glebik.core.designsystem.settings.LocalSettingsEventBus
import ru.glebik.core.designsystem.settings.SettingsEventBus
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.widget.AppBar
import ru.glebik.feature.home.internal.presentation.ui.HomeScreen
import ru.glebik.feature.profile.internal.presentation.ui.ProfileScreen
import ru.glebik.feature.search.internal.SearchScreen

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {

            val settingsEventBus = remember { SettingsEventBus() }

            val currentSettings = settingsEventBus.currentSettings.collectAsState().value

            AppTheme(
                currentSettings.isDarkMode
            ) {
                CompositionLocalProvider(
                    LocalSettingsEventBus provides settingsEventBus
                ) {
                    InitialNavigator()
                }
            }
        }

    }
}

@Composable
fun InitialNavigator() {
    Navigator(
        HomeScreen,
    ) { navigator ->
        Scaffold(
            topBar = {
                AppBar({
                    navigator.push(SearchScreen)
                }, {
                    navigator.push(ProfileScreen)
                })
            },
            content = {
                Box(
                    Modifier
                        .padding(it)
                        .fillMaxSize()
                ) {
                    CurrentScreen()
                }
            },
        )

    }
}

object TestScreen : Screen {
    @Composable
    override fun Content() {
        Text(text = "sdfsdf")
    }
}


