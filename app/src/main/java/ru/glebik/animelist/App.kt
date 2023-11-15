package ru.glebik.animelist

import android.app.Application
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.MainScope
import kotlinx.coroutines.launch
import org.koin.android.BuildConfig
import org.koin.android.ext.android.inject
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.GlobalContext.startKoin
import ru.glebik.core.db.di.databaseModule
import ru.glebik.core.network.di.networkModule
import ru.glebik.feature.home.api.usecase.SearchAnimeUseCase
import ru.glebik.feature.home.internal.di.homeModule
import timber.log.Timber

class App : Application() {

    override fun onCreate() {
        super.onCreate()

        Timber.plant(Timber.DebugTree())

        startKoin {
            androidLogger()
            androidContext(this@App)

            modules(
                listOf(
                    networkModule,
                    homeModule,
                    databaseModule,
                )
            )
        }

        val searchAnimeUseCase: SearchAnimeUseCase by inject()

         MainScope().launch(Dispatchers.IO) {
            searchAnimeUseCase("naruto")
        }

    }
}