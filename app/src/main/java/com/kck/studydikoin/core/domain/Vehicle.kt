package com.kck.studydikoin.core.domain

data class Vehicle(
    val brand: String,
    val year: Int,
    val classification: CarClassification,
    val powerType: PowerType,
    val market: Market
) {

    enum class CarClassification {
        TRUCK, BUS,
        SPORTS, ROADSTER, CONVERTIBLE, SEDAN, HATCHBACK, SUV,
    }

    enum class PowerType {
        THERMIC, ELECTRIC, HYBRID,
    }

    enum class Market {
        WORLDWIDE, EUROPE, NA, ARABIC,
    }
}