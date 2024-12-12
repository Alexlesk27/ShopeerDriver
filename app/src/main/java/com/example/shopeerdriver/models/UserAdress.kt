package com.example.shopeerdriver.models

data class UserAdress(
    val destination: Destination,
    val distance: Int,
    val duration: Int? = 1,
    val options: List<Option>,
    val origin: Origin,
    val routeResponse: RouteResponse
)