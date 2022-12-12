package com.kck.studydikoin.repository

import com.kck.studydikoin.core.SourceTypeEnum
import com.kck.studydikoin.core.domain.Vehicle

interface IVehicleRepository {
    fun getVehicles(sourceType: SourceTypeEnum): List<Vehicle>
}