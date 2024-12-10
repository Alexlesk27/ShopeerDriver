package com.example.shopeerdriver.models

data class DestinationX(
    val geocoderStatus: GeocoderStatus,
    val placeId: String,
    val type: List<String>
)