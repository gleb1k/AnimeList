package ru.glebik.core.designsystem.theme.values

import androidx.compose.foundation.shape.CornerBasedShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

data class Colors(
    val primary: Color,
    val onPrimary: Color,

    val secondary: Color,
    val onSecondary: Color,

    val tint: Color,
    val background: Color,
    val surface : Color,

    val error: Color,
    val onError : Color,
)

data class Typography(
    val header: TextStyle,
    val subHeader : TextStyle,
    val body : TextStyle,
    val hint : TextStyle,

    val headerBold: TextStyle,
    val subHeaderBold : TextStyle,
    val bodyBold : TextStyle,
    val hintBold : TextStyle,
)

data class Padding (
    val verticalSmall: Dp,
    val horizontalSmall : Dp,

    val verticalMedium: Dp,
    val horizontalMedium : Dp,

    val verticalLarge: Dp,
    val horizontalLarge : Dp,
)

data class CornerShape(
    val small: CornerBasedShape,
    val medium: CornerBasedShape,
    val large: CornerBasedShape,
)