package ru.glebik.feature.profile.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import kotlinx.coroutines.CoroutineDispatcher
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.api.model.UserData
import ru.glebik.feature.auth.api.usecase.GetUserDataUseCase
import ru.glebik.feature.auth.api.usecase.IsUserAuthorizedUseCase

internal class ProfileStoreFactory(
    private val storeFactory: StoreFactory,

    private val getUserDataUserUseCase: GetUserDataUseCase,
    private val isUserAuthorizedUseCase: IsUserAuthorizedUseCase,
    private val ioDispatcher: CoroutineDispatcher,
) {
    fun create(): ProfileStore = object :
        ProfileStore,
        Store<ProfileStore.Intent, ProfileStore.State, ProfileStore.Label> by storeFactory.create(
            name = ProfileStore::class.simpleName,
            initialState = ProfileStore.State(),
            bootstrapper = null,
            executorFactory = {
                ProfileExecutor(
                    getUserDataUserUseCase,
                    isUserAuthorizedUseCase,
                    ioDispatcher
                )
            },
            reducer = ProfileReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetUser(
            val userData: UserData
        ) : Message

        data class SetIsAuth(
            val isAuth: Boolean
        ) : Message

        data class SetError(val error: ResultWrapper.Failed) : Message
    }
}
