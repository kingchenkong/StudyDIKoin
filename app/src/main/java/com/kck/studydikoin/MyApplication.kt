package com.kck.studydikoin

import android.app.Application
import com.kck.studydikoin.core.repositories.GitHubUsersRepositoryImpl
import com.kck.studydikoin.core.repositories.IGitHubUsersRepository
import com.kck.studydikoin.di.VehicleModule
import com.kck.studydikoin.di.gitHubModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level
import org.koin.dsl.module

class MyApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.ERROR)
            androidContext(this@MyApplication)

            modules(
//                VehicleModule,
                gitHubModule
            )
        }
    }
}