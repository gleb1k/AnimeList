package ru.glebik.core.widget

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import ru.glebik.core.designsystem.theme.AppTheme

@Composable
fun ContentCard(
    content: @Composable ColumnScope.() -> Unit,
) {
    ElevatedCard(
        shape = AppTheme.cornerShape.small,
        content = content
    )
}

@Preview
@Composable
private fun ContentCardPreview() {
    ElevatedCard(
        shape = RoundedCornerShape(4.dp),
        modifier = Modifier.width(200.dp)
    )
    {
        Box {

            Image(
                painter = painterResource(id = R.drawable.jutsu),
                contentDescription = "Image",
                contentScale = ContentScale.FillWidth,
                modifier = Modifier.fillMaxWidth()
            )
            Text(
                text = "5.0",
                color = Color.Black,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(4.dp)
                    .background(Color.Green)
            )
        }
        Text(
            text = "Jutsu",
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 4.dp)
        )
    }
}