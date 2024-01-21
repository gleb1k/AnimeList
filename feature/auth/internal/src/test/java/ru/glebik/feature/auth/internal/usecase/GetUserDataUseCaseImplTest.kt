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
import ru.glebik.feature.auth.api.model.UserData
import ru.glebik.feature.auth.internal.data.AuthRepositoryImpl

class GetUserDataUseCaseImplTest {

    @MockK
    private lateinit var authRepository: AuthRepositoryImpl

    private lateinit var useCase: GetUserDataUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = GetUserDataUseCaseImpl(authRepository)
    }

    @Test
    fun whenGetUserDataUseCaseImplTestExpectedSuccess() {
        val requestToken = TestConstants.GOOD_USER_TOKEN
        val expectedData: ResultWrapper.Success<UserData> = mockk()
        coEvery {
            authRepository.getUserById(requestToken)
        } returns expectedData

        runTest {
            val result = useCase(requestToken) as ResultWrapper.Success

            assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenGetUserDataUseCaseImplExpectedFail() {
        val requestToken = TestConstants.BAD_USER_TOKEN
        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            authRepository.getUserById(requestToken)
        } returns expectedFail

        runTest {
            val result = useCase(requestToken)
            assertEquals(expectedFail, result)
        }
    }
}