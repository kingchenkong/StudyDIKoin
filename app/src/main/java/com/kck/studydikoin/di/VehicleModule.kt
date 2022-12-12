package com.kck.studydikoin

import com.kck.studydikoin.domain.usecases.GetVehicleUseCaseImpl
import com.kck.studydikoin.domain.usecases.IGetVehiclesUseCase
import org.koin.dsl.bind
import org.koin.dsl.module

val VehicleModule = module {
    single { GetVehicleUseCaseImpl() } bind IGetVehiclesUseCase::class
}