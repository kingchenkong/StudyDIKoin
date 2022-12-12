package com.kck.studydikoin.repository

import com.kck.studydikoin.core.SourceTypeEnum
import com.kck.studydikoin.core.domain.Vehicle


class VehicleRepositoryImpl : IVehicleRepository {
    override fun getVehicles(sourceType: SourceTypeEnum): List<Vehicle> {
        return when (sourceType) {
            SourceTypeEnum.LOCAL -> generateLocalList()
            SourceTypeEnum.ON_REMOTE -> emptyList()
        }
    }

    private fun generateLocalList(): List<Vehicle> {
        return listOf(
            Vehicle(
                "Toyota",
                2022,
                Vehicle.CarClassification.SEDAN,
                Vehicle.PowerType.ELECTRIC,
                Vehicle.Market.WORLDWIDE
            ),
            Vehicle(
                "BMW",
                2019,
                Vehicle.CarClassification.ROADSTER,
                Vehicle.PowerType.THERMIC,
                Vehicle.Market.EUROPE
            ),
        )
    }
}