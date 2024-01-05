package ru.glebik.core.widget.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.widget.BackAppBar
import ru.glebik.core.widget.BaseSurface
import ru.glebik.core.widget.BaseTextButton

@Composable
fun NotAuthorizedView(
    onSignInClick: () -> Unit,
    onSignUpClick: () -> Unit,
    onBackClick: () -> Unit,
) {
    BaseSurface {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            BackAppBar(onBackClick)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier.fillMaxSize(),
            ) {
                Text(text = "Вы не авторизованы", style = AppTheme.typography.body)

                Text(text = "Зарегистрироваться",
                    style = AppTheme.typography.bodyBold,
                    modifier = Modifier.clickable {
                        onSignUpClick.invoke()
                    })
                BaseTextButton(
                    text = "Авторизоваться"
                ) {
                    onSignInClick.invoke()
                }

            }
        }
    }
}