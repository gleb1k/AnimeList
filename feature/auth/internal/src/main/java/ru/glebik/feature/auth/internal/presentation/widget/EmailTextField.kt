package ru.glebik.feature.auth.internal.presentation.widget

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Mail
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import ru.glebik.core.designsystem.theme.AppTheme

@Composable
fun EmailTextField(
    value: String = "",
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default,
    keyboardActions: KeyboardActions = KeyboardActions.Default,
    onValueChange: (String) -> Unit,
) {
    //TODO Я НЕ ПОНИМАЮ ПОЧЕМУ КУРСОР ОТСТАЕТ, И Я НЕ ПОНИМАЮ КАК ЭТО ФИКСИТЬ
    // https://issuetracker.google.com/issues/160257648
    //ВОТ ТУТ ЛЮДИ МУЧАЛИСЬ ЕЩЕ 2 ГОДА НАЗАД
    //Я ПОПРОБОВАЛ НЕ ВЫШЛО
    //ЕСЛИ ПИСАТЬ МЕДЛЕННО - ТО ВСЕ ОК, НО КАК ТОЛЬКО УСКОРЯЕШЬ СКОРОСТЬ НАБОРА, КУРСОР СНОВА ОТСТАЕТ.
    //МБ ДЕЛО В IO ПОТОКЕ? ИЛИ MVI KOTLIN ВСЕ СЛОМАЛ
    var inputText by remember(value) { mutableStateOf(value) }

    TextField(
        value = inputText,
        onValueChange = {
            inputText = it
            onValueChange.invoke(it)
        },
        modifier = Modifier
            .fillMaxWidth(),
        placeholder = {
            Text(
                text = "Email",
                style = AppTheme.typography.hint
            )
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        shape = RoundedCornerShape(18.dp),
        singleLine = true,
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Mail,
                contentDescription = "Email",
                Modifier.size(24.dp)
            )
        },
        colors = TextFieldDefaults.colors(
            focusedContainerColor = AppTheme.colors.background,
            unfocusedContainerColor = AppTheme.colors.background,
            disabledContainerColor = AppTheme.colors.background,
            focusedIndicatorColor = Color.Transparent,
            unfocusedIndicatorColor = Color.Transparent,
            disabledIndicatorColor = Color.Transparent,
        ),
    )

}