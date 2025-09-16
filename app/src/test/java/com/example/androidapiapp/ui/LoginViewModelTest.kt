package com.example.androidapiapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidapiapp.models.DataModels
import com.example.androidapiapp.repository.Repository
import com.example.androidapiapp.utilities.TestCoroutineRule
import com.example.androidapiapp.utilities.getOrAwaitValue
import junit.framework.TestCase.assertNull
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExperimentalCoroutinesApi
class LoginViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()
    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var repo: Repository
    private lateinit var viewModel: LoginViewModel

    @Before
    fun setup() {
        repo = mock()
        viewModel = LoginViewModel(repo)
    }

    @Test
    fun `login success updates LiveData`() = runTest {
        //Given
        val expected = DataModels.LoginResponse("myKey")
        whenever(repo.login("footscray", "Patrick","8081856"))
            .thenReturn(expected)

        //When
        viewModel.login("footscray", "Patrick","8081856")
        testCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()

        //Then
        assertEquals(expected, viewModel.loginResult.getOrAwaitValue())
    }

    @Test
    fun `login failure sets LiveData null`() = runTest {
        whenever(repo.login("footscray", "John","4897653"))
            .thenReturn(null)

        viewModel.login("footscray", "John","4897653")
        testCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()

        assertNull(viewModel.loginResult.getOrAwaitValue())
    }
}