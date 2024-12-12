package com.example.shopeerdriver.support.state

sealed class ApiState {
    data class Success<T>(val data: T): ApiState()
    data class Error(val error: String): ApiState()
    class Loading : ApiState()
}