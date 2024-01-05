package ru.glebik.core.widget

import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import ru.glebik.core.designsystem.theme.AppTheme

@Composable
fun BaseSurface(
    content: @Composable () -> Unit
) {
    Surface(
        color = AppTheme.colors.surface
    ) {
        content()
    }
}
