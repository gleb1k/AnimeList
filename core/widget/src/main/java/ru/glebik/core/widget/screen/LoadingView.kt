package ru.glebik.core.widget.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.widget.BaseSurface

@Composable
fun LoadingView() {
    BaseSurface {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            CircularProgressIndicator(
                color = AppTheme.colors.secondary,
            )
            Spacer(modifier = Modifier.padding(4.dp))
            Text("Loading Content", style = AppTheme.typography.body)
        }
    }
}