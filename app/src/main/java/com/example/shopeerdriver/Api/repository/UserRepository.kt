package com.example.shopeerdriver.Api.repository

import com.example.shopeerdriver.models.Option
import com.example.shopeerdriver.models.User
import com.example.shopeerdriver.models.UserAdress

class UserRepository(
    val userAddressApi: UserAddressApi
) {

    suspend fun searchUserAddress(userAddress: User): Option{
       return userAddressApi.searchUserAddress(userAddress)
    }
}