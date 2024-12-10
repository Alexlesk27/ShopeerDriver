package com.example.shopeerdriver.models

data class Leg(
    val distanceMeters: Int,
    val duration: String,
    val endLocation: EndLocation,
    val localizedValues: LocalizedValuesXX,
    val polyline: PolylineXX,
    val startLocation: StartLocation,
    val staticDuration: String,
    val steps: List<Step>
)