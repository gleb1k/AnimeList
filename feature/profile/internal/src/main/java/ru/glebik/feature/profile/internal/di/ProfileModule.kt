package ru.glebik.feature.profile.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.feature.profile.internal.presentation.ui.ProfileScreen
import ru.glebik.feature.profile.internal.presentation.viewmodel.MviProfileScreenModel
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileStore
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileStoreFactory

val profileModule = module {

    factory<ProfileStore> {
        ProfileStoreFactory(
            storeFactory = get(),
        ).create()
    }

    factory<MviProfileScreenModel> { MviProfileScreenModel(get()) }
}

val profileScreenModule = screenModule {
    register<SharedScreen.Profile> { ProfileScreen }
}