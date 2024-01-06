package ru.glebik.feature.auth.internal.presentation.signup

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
import ru.glebik.feature.auth.internal.presentation.signup.viewmodel.SignUpScreenModel
import ru.glebik.feature.auth.internal.presentation.signup.viewmodel.SignUpStore
import ru.glebik.feature.auth.internal.presentation.widget.EmailTextField
import ru.glebik.feature.auth.internal.presentation.widget.NicknameTextField
import ru.glebik.feature.auth.internal.presentation.widget.PasswordTextField

object SignUpScreen : Screen {
    private fun readResolve(): Any = SignUpScreen

    @Composable
    override fun Content() {
        SignUpScreen()
    }

    @Composable
    private fun SignUpScreen(
        viewModel: SignUpScreenModel = getScreenModel()
    ) {
        val navigator = LocalNavigator.currentOrThrow
        val state by viewModel.state.collectAsStateWithLifecycle()
        val label by viewModel.label.collectAsStateWithLifecycle(initialValue = null)

        val signInScreen = rememberScreen(SharedScreen.SignIn)

        when (label) {
            null -> Unit
            is SignUpStore.Label.NavigateToSignIn -> {
                navigator.push(signInScreen)
            }
        }



        SignUpView(
            state,
            viewModel::onQueryEmailChange,
            viewModel::onQueryPasswordChange,
            viewModel::onQueryNicknameChange,
            viewModel::onSignUpClick,
            navigator::pop
        )
    }

    @Composable
    private fun SignUpView(
        state: SignUpStore.State,
        onQueryEmailChange: (query: String) -> Unit,
        onQueryPasswordChange: (query: String) -> Unit,
        onQueryNicknameChange: (query: String) -> Unit,
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
                    verticalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(horizontal = AppTheme.padding.horizontalLargeBase),
                ) {
                    Text(
                        text = "Sign up",
                        style = AppTheme.typography.headerBold
                    )
                    Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                    Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
                    Column(
                        Modifier.fillMaxWidth()
                    ) {
                        Text(text = "Я НЕ ПОНИМАЮ ПОЧЕМУ ОТСТАЕТ КУРСОР :с")
                        NicknameTextField(
                            value = state.queryNickname
                        ) {
                            onQueryNicknameChange(it)
                        }
                        Spacer(modifier = Modifier.height(AppTheme.padding.verticalLarge))
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
                            text = "Sign up"
                        ) {
                            onSignUpClick()
                        }
                    }
                }
            }

        }

    }

}