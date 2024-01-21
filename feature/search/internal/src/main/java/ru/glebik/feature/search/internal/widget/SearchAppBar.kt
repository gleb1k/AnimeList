package ru.glebik.feature.search.internal.widget

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import cafe.adriel.voyager.navigator.Navigator

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchAppBar(
    navigator: Navigator,
    searchValue: String,
    onQuerySearchChange: (String) -> Unit,
    onSearchClick: (String) -> Unit,
) {
    //todo
    TopAppBar(
        title = {},
//        navigationIcon = {
//            IconButton(onClick = navigator::pop) {
//                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = null)
//            }
//        },
        actions = {
            SearchTextField(
                value = searchValue,
                onValueChange = onQuerySearchChange,
                onSearchClick = onSearchClick,
                onBackClick = navigator::pop
            )
        }
    )
}
