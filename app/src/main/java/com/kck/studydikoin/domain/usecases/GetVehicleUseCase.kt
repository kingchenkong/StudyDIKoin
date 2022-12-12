package com.kck.studydikoin.domain.usecases

import com.kck.studydikoin.core.SourceTypeEnum
import com.kck.studydikoin.core.domain.Vehicle
import com.kck.studydikoin.repository.VehicleRepositoryImpl
import org.koin.core.context.GlobalContext


interface IGetVehiclesUseCase {
    suspend fun invoke(sourceType: SourceTypeEnum): List<Vehicle>
}


class GetVehicleUseCaseImpl : IGetVehiclesUseCase {
    private val vehicleRepo: VehicleRepositoryImpl by GlobalContext.get().inject()

    override suspend fun invoke(sourceType: SourceTypeEnum): List<Vehicle> {
        return vehicleRepo.getVehicles(sourceType)
    }
}