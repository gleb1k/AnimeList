package ru.glebik.feature.anime.internal.domain

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeRecommendation
import ru.glebik.feature.anime.internal.data.AnimeRepositoryImpl
import kotlin.test.assertEquals

class GetAnimeRecommendationsUseCaseImplTest {

    @MockK
    private lateinit var animeRepositoryImpl: AnimeRepositoryImpl

    private lateinit var useCase: GetAnimeRecommendationsUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetAnimeRecommendationsUseCaseImpl(animeRepositoryImpl)
    }

    @Test
    fun whenGetAnimeRecommendationsUseCaseImplExpectedSuccess() {
        // arrange
        val requestId = TestConst.GOOD_ANIME_ID
        val expectedData: ResultWrapper.Success<List<AnimeRecommendation>> = mockk()
        coEvery {
            animeRepositoryImpl.getAnimeRecommendations(requestId)
        } returns expectedData

        // act
        runTest {
            val result = useCase(requestId)

            // assert
            assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenGetAnimeRecommendationsUseCaseImplExpectedFail() {
        // arrange
        val requestId = TestConst.BAD_ANIME_ID
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            animeRepositoryImpl.getAnimeRecommendations(requestId)
        } returns expectedFail
        // act
        runTest {
            val result = useCase(requestId)
            // assert
            assertEquals(expectedFail, result)
        }
    }
}