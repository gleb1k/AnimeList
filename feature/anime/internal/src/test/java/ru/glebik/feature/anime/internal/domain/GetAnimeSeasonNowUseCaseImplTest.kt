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

class GetAnimeSeasonNowUseCaseImplTest {

    @MockK
    private lateinit var animeRepositoryImpl: AnimeRepositoryImpl

    private lateinit var useCase: GetAnimeSeasonNowUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetAnimeSeasonNowUseCaseImpl(animeRepositoryImpl)
    }

    @Test
    fun whenGetAnimeSeasonNowUseCaseImplTestExpectedSuccess() {
        val expectedData: ResultWrapper.Success<List<AnimeBaseModel>> = mockk()
        coEvery {
            animeRepositoryImpl.getSeasonsNow()
        } returns expectedData

        runTest {
            val result = useCase() as ResultWrapper.Success

            kotlin.test.assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenGetAnimeSeasonNowUseCaseImplExpectedFail() {
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            animeRepositoryImpl.getSeasonsNow()
        } returns expectedFail

        runTest {
            val result = useCase()
            kotlin.test.assertEquals(expectedFail, result)
        }
    }
}