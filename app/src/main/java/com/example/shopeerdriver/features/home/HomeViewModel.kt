package com.example.shopeerdriver.features.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shopeerdriver.support.state.ApiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

class HomeViewModel(
    private val estimateRideCostUseCase: EstimateRideCostUseCaseInterface
): ViewModel() {

    private val _list = MutableStateFlow<ApiState>(ApiState.Loading())
    val list: StateFlow<ApiState> = _list.asStateFlow()
    var isAddressValid: Boolean = true




    fun validInputs(myAddress: String, destinationAddress: String): Boolean{
        if (myAddress.isBlank() ){
            isAddressValid = false
        } else if (destinationAddress.isBlank()){
            isAddressValid = false
        } else {
            isAddressValid = true
        }
        return isAddressValid
    }

    fun getText(customerId: String, origin: String, destination: String){
        viewModelScope.launch {
            estimateRideCostUseCase.execute(customerId, origin, destination).onStart {
                _list.value = ApiState.Loading()
            }.collect{
                when(it){
                    is ApiState.Success<*> -> _list.value = ApiState.Success(it)
                    is ApiState.Error -> _list.value = ApiState.Error(it.error)
                    is ApiState.Loading -> {}
                }
            }
        }
    }

}