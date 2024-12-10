package com.example.shopeerdriver.models

data class RouteResponse(
    val geocodingResults: GeocodingResults,
    val routes: List<Route>
)