package ru.glebik.core.widget.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.ClickableText
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
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
                .fillMaxSize(),
        ) {
            BackAppBar(onBackClick)
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center,
                modifier = Modifier
                    .fillMaxSize()
                    .padding(horizontal = AppTheme.padding.horizontalLargeBase)
            ) {
                Text(text = "You are not authorized", style = AppTheme.typography.headerBold)
                Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                ClickableText(
                    text = AnnotatedString("Sign up"),
                    style = AppTheme.typography.bodyBold,
                ) {
                    onSignUpClick.invoke()
                }
                Spacer(modifier = Modifier.height(AppTheme.padding.verticalBig))
                BaseTextButton(
                    text = "Sign in",
                    modifier = Modifier.fillMaxWidth(),
                    onClick = onSignInClick
                )
            }
        }
    }
}