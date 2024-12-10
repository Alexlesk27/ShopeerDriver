package com.example.shopeerdriver.models

data class UserAdress(
    val destination: Destination,
    val distance: Int,
    val duration: Int,
    val options: List<Option>,
    val origin: Origin,
    val routeResponse: RouteResponse
)