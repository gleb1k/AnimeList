package ru.glebik.animelist

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.designsystem.theme.settings.LocalSettingsEventBus
import ru.glebik.core.designsystem.theme.settings.SettingsEventBus

class MainActivity : ComponentActivity() {
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
                    Surface(
                        modifier = Modifier.fillMaxSize(),
                        color = MaterialTheme.colorScheme.background
                    ) {
                        Text(
                            text = "TEXT TEXT TEXT ",
                            style = AppTheme.typography.body
                        )
                    }
                }
            }
        }
    }
}

