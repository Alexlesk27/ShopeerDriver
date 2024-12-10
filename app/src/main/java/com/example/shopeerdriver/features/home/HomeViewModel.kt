package com.example.shopeerdriver.features.home

import android.text.BoringLayout
import androidx.lifecycle.ViewModel

class HomeViewModel(): ViewModel() {

    var isAddressValid: Boolean = false


    fun validInputs(myAddress: String, destinationAddress: String): Boolean{
        if (!myAddress.isEmpty() && destinationAddress.isEmpty()){
            isAddressValid = true
        }
        return isAddressValid
    }

}