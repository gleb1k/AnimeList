package ru.glebik.feature.anime.internal.domain

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeBaseModel
import ru.glebik.feature.anime.internal.data.AnimeRepositoryImpl

class GetTopAnimeByScoreUseCaseImplTest {
    @MockK
    private lateinit var animeRepositoryImpl: AnimeRepositoryImpl

    private lateinit var useCase: GetTopAnimeByScoreUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetTopAnimeByScoreUseCaseImpl(animeRepositoryImpl)
    }

    @Test
    fun whenGetTopAnimeByScoreUseCaseImplTestExpectedSuccess() {
        val expectedData: ResultWrapper.Success<List<AnimeBaseModel>> = mockk()
        coEvery {
            animeRepositoryImpl.getTopAnime(null)
        } returns expectedData

        runTest {
            val result = useCase() as ResultWrapper.Success

            assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenGetTopAnimeByScoreUseCaseImplExpectedFail() {
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            animeRepositoryImpl.getTopAnime(null)
        } returns expectedFail

        runTest {
            val result = useCase()
            assertEquals(expectedFail, result)
        }
    }
}