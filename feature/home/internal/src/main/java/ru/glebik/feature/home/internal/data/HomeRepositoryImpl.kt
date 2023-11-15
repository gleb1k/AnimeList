package ru.glebik.feature.home.internal.data

import android.util.Log
import ru.glebik.feature.home.api.repository.HomeRepository
import ru.glebik.feature.home.api.service.AnimeService
import ru.glebik.feature.home.api.service.response.animesearch.AnimeSearchData
import timber.log.Timber

internal class HomeRepositoryImpl(
    private val animeService : AnimeService,
    //dao,
    //mapper,
) : HomeRepository {
    override suspend fun searchAnime(q: String): List<AnimeSearchData> {

        return animeService.searchAnime(q).animeSearchData?: listOf<AnimeSearchData>().also {
            Log.e("sdfsdf","dsfdsf")
            Timber.e("DSFDSFSFD")
            Timber.e(it.first().toString())
        }
    }
}