package ru.glebik.feature.anime.internal.domain

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.every
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.anime.api.model.domain.AnimeFull
import ru.glebik.feature.anime.internal.data.AnimeRepositoryImpl
import kotlin.test.assertEquals

class GetAnimeFullUseCaseImplTest {

    @MockK
    private lateinit var animeRepositoryImpl: AnimeRepositoryImpl

    private lateinit var useCase: GetAnimeFullUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetAnimeFullUseCaseImpl(animeRepositoryImpl)
    }

    @Test
    fun whenGetAnimeFullUseCaseImplTestExpectedSuccess() {
        val requestId = TestConst.GOOD_ANIME_ID
        val expectedData: ResultWrapper.Success<AnimeFull> = mockk {
            every { data.malId } returns requestId
        }
        coEvery {
            animeRepositoryImpl.getAnimeFull(requestId)
        } returns expectedData

        runTest {
            val result = useCase(requestId) as ResultWrapper.Success

            assertEquals(expectedData, result)
            assertEquals(requestId, result.data.malId)
        }
    }

    @Test
    fun whenGetAnimeFullUseCaseImplExpectedFail() {
        val requestId = TestConst.BAD_ANIME_ID
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            animeRepositoryImpl.getAnimeFull(requestId)
        } returns expectedFail

        runTest {
            val result = useCase(requestId)
            assertEquals(expectedFail, result)
        }
    }

}