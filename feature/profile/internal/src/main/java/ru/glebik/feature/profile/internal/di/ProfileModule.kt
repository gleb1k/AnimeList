package ru.glebik.feature.profile.internal.di

import cafe.adriel.voyager.core.registry.screenModule
import org.koin.core.qualifier.named
import org.koin.dsl.module
import ru.glebik.core.navigation.SharedScreen
import ru.glebik.core.utils.di.CoroutineDispatchers
import ru.glebik.feature.profile.internal.presentation.ui.ProfileScreen
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileScreenModel
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileStore
import ru.glebik.feature.profile.internal.presentation.viewmodel.ProfileStoreFactory

val profileModule = module {

    factory<ProfileStore> {
        ProfileStoreFactory(
            storeFactory = get(),
            getUserDataUserUseCase = get(
            ),
            isUserAuthorizedUseCase = get(),
            ioDispatcher = get(named(CoroutineDispatchers.IO))
        ).create()
    }

    factory<ProfileScreenModel> { ProfileScreenModel(get()) }
}

val profileScreenModule = screenModule {
    register<SharedScreen.Profile> { ProfileScreen }
}