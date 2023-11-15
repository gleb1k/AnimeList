package ru.glebik.core.network.di


import android.util.Log
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.defaultRequest
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logger
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.plugins.observer.ResponseObserver
import io.ktor.http.URLProtocol
import io.ktor.serialization.kotlinx.json.json

import org.koin.dsl.module
import ru.glebik.core.network.NetworkConstants

val networkModule = module {

    single<HttpClient> {
        HttpClient(OkHttp) {
            defaultRequest {
                url {
                    protocol = URLProtocol.HTTPS
                    host = NetworkConstants.ANIME_ENDPOINT
                    parameters.apply {
                        //...
                    }
                }
            }
            engine {
                config {
                    followRedirects(true)
                }
            }
            install(ContentNegotiation) {
                json()
            }
            install(Logging) {
                logger = object : Logger {
                    override fun log(message: String) {
                        Log.v("Logger Ktor =>", message)
                    }

                }
                level = LogLevel.ALL
            }

            install(ResponseObserver) {
                onResponse { response ->
                    Log.d("HTTP status:", "${response.status.value}")
                }
            }
        }
    }
}




