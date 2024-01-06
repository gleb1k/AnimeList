package ru.glebik.feature.auth.internal.presentation.signin

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = AppTheme.padding.horizontalLargeBase),
                ) {
                    Text(
                        text = "Sign in",
                        style = AppTheme.typography.headerBold
                    )
                    Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                    Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                    //TODO Я НЕ ПОНИМАЮ ПОЧЕМУ ОТСТАЕТ ЗАПИСЬ, КАК ФИКСИТЬ ТОЖЕ ХЗ
                    Column(
                        Modifier.fillMaxWidth()
                    ) {
                        EmailTextField(
                            value = state.queryEmail
                        ) {
                            onQueryEmailChange(it)
                        }
                        Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                        PasswordTextField(
                            value = state.queryPassword
                        ) {
                            onQueryPasswordChange(it)
                        }
                        Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                        Text(text = "Error: ${state.isError}")
                        Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                        BaseTextButton(
                            modifier = Modifier.fillMaxWidth(),
                            text = "Sign in"
                        ) {
                            onSignInClick()
                        }
                    }
                }
            }
        }
    }
}


