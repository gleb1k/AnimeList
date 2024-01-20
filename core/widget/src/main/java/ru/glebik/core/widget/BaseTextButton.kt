package ru.glebik.core.widget

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import ru.glebik.core.designsystem.theme.AppTheme

@Composable
fun BaseTextButton(
    modifier: Modifier = Modifier,
    text: String = "",
    textStyle: TextStyle = AppTheme.typography.onButton,
    onClick: () -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = AppTheme.cornerShape.large,
        colors = ButtonDefaults.buttonColors(
            containerColor = AppTheme.colors.primary,
            contentColor = AppTheme.colors.onPrimary
        )
    ) {
        Text(
            text = text,
            style = textStyle,
            modifier = Modifier
                .padding(horizontal = AppTheme.padding.horizontalMedium)
        )
    }
}