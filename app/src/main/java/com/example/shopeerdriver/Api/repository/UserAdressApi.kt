package com.example.shopeerdriver.Api.repository

import com.example.shopeerdriver.models.Option
import com.example.shopeerdriver.models.User
import com.example.shopeerdriver.models.UserAdress
import retrofit2.http.Body
import retrofit2.http.POST

interface UserAddressApi {

    @POST("/ride/estimate")
    suspend fun searchUserAddress(
        @Body user: User
    ): Option

}