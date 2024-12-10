package com.example.shopeerdriver.models

data class OriginX(
    val geocoderStatus: GeocoderStatus,
    val placeId: String,
    val type: List<String>
)