package com.example.shopeerdriver.features.home

import com.example.shopeerdriver.Api.repository.UserRepository
import com.example.shopeerdriver.models.Option
import com.example.shopeerdriver.models.User
import com.example.shopeerdriver.models.UserAdress
import com.example.shopeerdriver.support.state.ApiState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import okhttp3.Dispatcher

interface EstimateRideCostUseCaseInterface{
    suspend fun execute(customerId: String, origin: String, destination: String): Flow<ApiState>
}

class EstimateRideCostUseCase(val repository: UserRepository): EstimateRideCostUseCaseInterface {
    override suspend fun execute(customerId: String, origin: String, destination: String): Flow<ApiState> {
        return flow {
            try {
                val estimateRideCostUse = repository.searchUserAddress(User(customerId, origin, destination))
                emit(ApiState.Success(estimateRideCostUse))
            }catch (e: Error){
                emit(ApiState.Error(e.message.toString()))
            }
        }.flowOn(Dispatchers.IO)
    }
}