package ru.glebik.feature.auth.internal.usecase

import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import io.mockk.mockk
import kotlinx.coroutines.test.runTest
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import ru.glebik.core.utils.ResultWrapper
import ru.glebik.feature.auth.internal.data.AuthRepositoryImpl

class IsUserAuthorizedUseCaseImplTest {

    @MockK
    private lateinit var authRepository: AuthRepositoryImpl

    private lateinit var useCase: IsUserAuthorizedUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = IsUserAuthorizedUseCaseImpl(authRepository)
    }

    @Test
    fun whenIsUserAuthorizedUseCaseImplTestExpectedSuccess() {
        val expectedData: ResultWrapper.Success<Boolean> = mockk()
        coEvery {
            authRepository.isUserAuthorized()
        } returns expectedData

        runTest {
            val result = useCase() as ResultWrapper.Success

            assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenIsUserAuthorizedUseCaseImplExpectedFail() {
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            authRepository.isUserAuthorized()
        } returns expectedFail

        runTest {
            val result = useCase()
            assertEquals(expectedFail, result)
        }
    }
}