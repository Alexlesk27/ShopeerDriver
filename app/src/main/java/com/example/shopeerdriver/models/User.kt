package com.example.shopeerdriver.models

import com.google.gson.annotations.SerializedName

data class User(
    @SerializedName("customer_id")
    val customerId: String,
    val origin: String,
    val destination: String
)