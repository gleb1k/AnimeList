package ru.glebik.feature.auth.internal.presentation.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import ru.glebik.core.designsystem.theme.AppTheme
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.widget.BackAppBar
import ru.glebik.core.widget.BaseSurface
import ru.glebik.core.widget.BaseTextButton
import ru.glebik.feature.auth.internal.presentation.signin.viewmodel.SignInScreenModel
import ru.glebik.feature.auth.internal.presentation.signin.viewmodel.SignInStore
import ru.glebik.feature.auth.internal.presentation.widget.EmailTextField
import ru.glebik.feature.auth.internal.presentation.widget.PasswordTextField

object SignInScreen : Screen {

    private fun readResolve(): Any = SignInScreen

    @Composable
    override fun Content() {
        SignInScreen()
    }

    @Composable
    private fun SignInScreen(
        viewModel: SignInScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()
        val label by viewModel.label.collectAsStateWithLifecycle(initialValue = null)

        val profileScreen = rememberScreen(SharedScreen.Profile)

        when (label) {
            null -> Unit
            SignInStore.Label.NavigateToProfile -> navigator.push(profileScreen)
        }

        SignInView(
            state,
            viewModel::onQueryEmailChange,
            viewModel::onQueryPasswordChange,
            viewModel::onSignInClick,
            navigator::pop
        )
    }

    @Composable
    private fun SignInView(
        state: SignInStore.State,
        onQueryEmailChange: (query: String) -> Unit,
        onQueryPasswordChange: (query: String) -> Unit,
        onSignInClick: () -> Unit,
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
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = AppTheme.padding.horizontalLargeBase),
                ) {

                    Text(
                        text = "Вход в профиль",
                        style = AppTheme.typography.headerBold
                    )

                    //TODO Я НЕ ПОНИМАЮ ПОЧЕМУ ОТСТАЕТ ЗАПИСЬ, КАК ФИКСИТЬ ТОЖЕ ХЗ
                    EmailTextField(
                        value = state.queryEmail
                    ) {
                        onQueryEmailChange(it)

                    }
                    PasswordTextField(
                        value = state.queryPassword
                    ) {
                        onQueryPasswordChange(it)
                    }

                    Text(text = state.isError.toString())

                    BaseTextButton(
                        text = "Войти"
                    ) {
                        onSignInClick()
                    }

                }
            }
        }
    }
}


