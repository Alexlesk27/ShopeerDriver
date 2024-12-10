package com.example.shopeerdriver.models

data class Option(
    val description: String,
    val id: Int,
    val name: String,
    val review: Review,
    val value: Double,
    val vehicle: String
)