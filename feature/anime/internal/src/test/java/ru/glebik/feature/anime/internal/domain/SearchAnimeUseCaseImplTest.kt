package ru.glebik.feature.anime.internal.domain

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.internal.data.AnimeRepositoryImpl

class SearchAnimeUseCaseImplTest {
    @MockK
    private lateinit var animeRepositoryImpl: AnimeRepositoryImpl

    private lateinit var useCase: SearchAnimeUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = SearchAnimeUseCaseImpl(animeRepositoryImpl)
    }

    @Test
    fun whenSearchAnimeUseCaseImplTestExpectedSuccess() {
        val requestQuery = "Naruto"
        val expectedData: ResultWrapper.Success<List<AnimeBaseModel>> = mockk()
        coEvery {
            animeRepositoryImpl.searchAnime(requestQuery)
        } returns expectedData

        runTest {
            val result = useCase(requestQuery) as ResultWrapper.Success

            kotlin.test.assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenSearchAnimeUseCaseImplExpectedFail() {
        val requestQuery = "123123123"
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            animeRepositoryImpl.searchAnime(requestQuery)
        } returns expectedFail

        runTest {
            val result = useCase(requestQuery)
            kotlin.test.assertEquals(expectedFail, result)
        }
    }
}