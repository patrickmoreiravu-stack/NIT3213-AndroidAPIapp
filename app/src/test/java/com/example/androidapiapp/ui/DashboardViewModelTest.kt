package com.example.androidapiapp.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.example.androidapiapp.models.DataModels
import com.example.androidapiapp.repository.Repository
import com.example.androidapiapp.utilities.TestCoroutineRule
import com.example.androidapiapp.utilities.getOrAwaitValue
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.mockito.Mockito.mock
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals
import kotlin.test.assertNull

@ExperimentalCoroutinesApi
class DashboardViewModelTest {

    @get:Rule
    val instantExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    val testCoroutineRule = TestCoroutineRule()

    private lateinit var repo: Repository
    private lateinit var viewModel: DashboardViewModel

    @Before
    fun setup() {
        repo = mock()
        viewModel = DashboardViewModel(repo)
    }

    @Test
    fun `loadDashboard success updates LiveData`() = runTest {
        val entities = listOf(DataModels.Entity("Prop1", "Prop2", "Desc"))
        val expected = DataModels.DashboardResponse(entities, entities.size)

        whenever(repo.getDashboard("myKey")).thenReturn(expected)

        viewModel.loadDashboard("myKey")
        testCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()

        assertEquals(expected, viewModel.dashboardData.getOrAwaitValue())
    }

    @Test
    fun `loadDashboard failure sets LiveData null`() = runTest {
        whenever(repo.getDashboard("myKey")).thenReturn(null)

        viewModel.loadDashboard("myKey")
        testCoroutineRule.testDispatcher.scheduler.advanceUntilIdle()

        assertNull(viewModel.dashboardData.getOrAwaitValue())
    }
}