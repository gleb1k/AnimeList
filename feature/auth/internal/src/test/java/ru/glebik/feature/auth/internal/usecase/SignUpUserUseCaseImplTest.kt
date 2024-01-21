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

class SignUpUserUseCaseImplTest {

    @MockK
    private lateinit var authRepository: AuthRepositoryImpl

    private lateinit var useCase: SignUpUserUseCaseImpl

    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        useCase = SignUpUserUseCaseImpl(authRepository)
    }

    @Test
    fun whenSignUpUserUseCaseImplTestExpectedSuccess() {
        val name = TestConstants.USER_NAME
        val email = TestConstants.GOOD_USER_EMAIL
        val password = TestConstants.GOOD_USER_PASSWORD

        val expectedData: ResultWrapper.Success<Boolean> = mockk()
        coEvery {
            authRepository.signUp(name, email, password)
        } returns expectedData

        runTest {
            val result = useCase(name, email, password) as ResultWrapper.Success

            assertEquals(expectedData, result)
        }
    }

    @Test
    fun whenSignUpUserUseCaseImplExpectedFail() {
        val name = TestConstants.USER_NAME
        val email = TestConstants.BAD_USER_EMAIL
        val password = TestConstants.BAD_USER_PASSWORD

        val expectedFail: ResultWrapper.Failed = mockk()
        coEvery {
            authRepository.signUp(name, email, password)
        } returns expectedFail

        runTest {
            val result = useCase(name, email, password)
            assertEquals(expectedFail, result)
        }
    }
}