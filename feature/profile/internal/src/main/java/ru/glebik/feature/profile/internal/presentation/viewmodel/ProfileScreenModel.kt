package ru.glebik.feature.profile.internal.presentation.viewmodel

import ru.glebik.core.presentation.MviScreenModel


class MviProfileScreenModel(
    private val store: ProfileStore,
) : MviScreenModel<ProfileStore.Intent, ProfileStore.State, ProfileStore.Label>(
    store
) {

    init {
        loadUserData()
    }

    private fun loadUserData() = store.accept(ProfileStore.Intent.LoadUserData)

}
