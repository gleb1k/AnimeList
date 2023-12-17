package ru.glebik.feature.profile.internal.presentation.viewmodel

import com.arkivanov.mvikotlin.core.store.Store
import com.arkivanov.mvikotlin.core.store.StoreFactory
import ru.glebik.core.utils.ResultWrapper

internal class ProfileStoreFactory(
    private val storeFactory: StoreFactory,
) {
    fun create(): ProfileStore = object :
        ProfileStore,
        Store<ProfileStore.Intent, ProfileStore.State, ProfileStore.Label> by storeFactory.create(
            name = ProfileStore::class.simpleName,
            initialState = ProfileStore.State(),
            bootstrapper = null,
            executorFactory = {
                ProfileExecutor(

                )
            },
            reducer = ProfileReducer(),
        ) {}

    sealed interface Message {
        data object SetLoading : Message
        data class SetUser(
            val userData: UserData
        ) : Message

        data class SetError(val error: ResultWrapper.Failed) : Message
    }
}
