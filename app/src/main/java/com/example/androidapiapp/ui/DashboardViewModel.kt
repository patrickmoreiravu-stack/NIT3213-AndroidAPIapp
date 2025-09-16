package com.example.androidapiapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.androidapiapp.data.DashboardResponse
import com.example.androidapiapp.repository.Repository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repo: Repository)
    : ViewModel() {

    private val _dashboardData = MutableLiveData<DashboardResponse?>()
    val dashboardData: LiveData<DashboardResponse?> = _dashboardData

    fun loadDashboard(keypass: String) {
        viewModelScope.launch {
            try {
                val response = repo.getDashboard(keypass)
                _dashboardData.postValue(response)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }
}