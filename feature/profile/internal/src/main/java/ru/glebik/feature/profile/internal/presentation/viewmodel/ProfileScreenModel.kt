package ru.glebik.feature.profile.internal.presentation.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class ProfileScreenModel(
    private val store: ProfileStore,
) : MviScreenModel<ProfileStore.Intent, ProfileStore.State, ProfileStore.Label>(
    store
) {
//
//    init {
//        checkIsAuth()
//
//        if (state.value.isAuth)
//            loadUserData()
//    }

    fun loadUserData() = store.accept(ProfileStore.Intent.LoadUserData)

    fun checkIsAuth() = store.accept(ProfileStore.Intent.CheckIsAuthorized)

}
