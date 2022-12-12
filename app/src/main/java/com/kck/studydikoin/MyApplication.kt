package com.kck.studydikoin

import android.app.Application
import com.kck.studydikoin.di.VehicleModule
import org.koin.core.context.startKoin

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin { VehicleModule }
    }
}