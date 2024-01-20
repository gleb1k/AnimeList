package ru.glebik.animelist

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.glebik.core.db.di.databaseModule
import ru.glebik.core.network.di.networkModule
import ru.glebik.core.presentation.di.presentationModule
import ru.glebik.core.utils.di.dispatchersModule
import ru.glebik.feature.anime.internal.di.animeModule
import ru.glebik.feature.auth.internal.di.authModule
import ru.glebik.feature.auth.internal.di.authScreenModule
import ru.glebik.feature.detail.internal.di.detailModule
import ru.glebik.feature.detail.internal.di.detailScreenModule
import ru.glebik.feature.home.internal.di.homeModule
import ru.glebik.feature.home.internal.di.homeScreenModule
import ru.glebik.feature.profile.internal.di.profileModule
import ru.glebik.feature.profile.internal.di.profileScreenModule
import ru.glebik.feature.search.internal.di.searchModule
import ru.glebik.feature.search.internal.di.searchScreenModule

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        ScreenRegistry {
            homeScreenModule()
            profileScreenModule()
            authScreenModule()
            searchScreenModule()
            detailScreenModule()
        }

        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(
                listOf(
                    dispatchersModule,
                    networkModule,
                    databaseModule,
                    animeModule,
                    presentationModule,
                    authModule,
                    searchModule,

                    homeModule,
                    profileModule,
                    detailModule,
                )
            )
        }

    }
}