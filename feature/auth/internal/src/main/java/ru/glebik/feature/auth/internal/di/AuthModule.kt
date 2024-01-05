package ru.glebik.feature.auth.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.utils.CoroutineDispatchers
import ru.glebik.core.utils.mapper.DaoMapper
import ru.glebik.feature.auth.api.model.UserData
import ru.glebik.feature.auth.api.model.UserEntity
import ru.glebik.feature.auth.api.repository.AuthRepository
import ru.glebik.feature.auth.api.usecase.GetUserDataUseCase
import ru.glebik.feature.auth.api.usecase.IsUserAuthorizedUseCase
import ru.glebik.feature.auth.api.usecase.SignInUserUseCase
import ru.glebik.feature.auth.api.usecase.SignUpUserUseCase
import ru.glebik.feature.auth.internal.data.AuthRepositoryImpl
import ru.glebik.feature.auth.internal.data.mapper.UserDaoMapper
import ru.glebik.feature.auth.internal.presentation.signin.SignInScreen
import ru.glebik.feature.auth.internal.presentation.signin.viewmodel.SignInScreenModel
import ru.glebik.feature.auth.internal.presentation.signin.viewmodel.SignInStore
import ru.glebik.feature.auth.internal.presentation.signin.viewmodel.SignInStoreFactory
import ru.glebik.feature.auth.internal.presentation.signup.SignUpScreen
import ru.glebik.feature.auth.internal.presentation.signup.viewmodel.SignUpScreenModel
import ru.glebik.feature.auth.internal.presentation.signup.viewmodel.SignUpStore
import ru.glebik.feature.auth.internal.presentation.signup.viewmodel.SignUpStoreFactory
import ru.glebik.feature.auth.internal.usecase.GetUserDataUseCaseImpl
import ru.glebik.feature.auth.internal.usecase.IsUserAuthorizedUseCaseImpl
import ru.glebik.feature.auth.internal.usecase.SignInUserUseCaseImpl
import ru.glebik.feature.auth.internal.usecase.SignUpUserUseCaseImpl

val authScreenModule = screenModule {
    register<SharedScreen.SignIn> { SignInScreen }
    register<SharedScreen.SignUp> { SignUpScreen }
}

val authModule = module {
    single<DaoMapper<UserEntity, UserData>>(
        named(UserDaoMapper.TAG)
    ) { UserDaoMapper() }

    factory<SignInUserUseCase> {
        SignInUserUseCaseImpl(get())
    }
    factory<SignUpUserUseCase> {
        SignUpUserUseCaseImpl(get())
    }
    factory<GetUserDataUseCase> {
        GetUserDataUseCaseImpl(get())
    }
    factory<IsUserAuthorizedUseCase> {
        IsUserAuthorizedUseCaseImpl(get())
    }

    factory<AuthRepository> {
        AuthRepositoryImpl(
            db = get(),
            ioDispatcher = get(named(CoroutineDispatchers.IO)),
            userDaoMapper = get(named(UserDaoMapper.TAG))
        )
    }

    factory<SignInStore> {
        SignInStoreFactory(
            storeFactory = get(),
            signInUserUseCase = get()
        ).create()
    }
    factory<SignUpStore> {
        SignUpStoreFactory(
            storeFactory = get(),
            signUpUserUseCase = get()
        ).create()
    }

    factory<SignInScreenModel> { SignInScreenModel(get()) }
    factory<SignUpScreenModel> { SignUpScreenModel(get()) }
}