package com.kck.studydikoin.di

import com.kck.studydikoin.core.network.RetrofitBuilder
import com.kck.studydikoin.core.network.URL_GIT_HUB
import com.kck.studydikoin.core.network.service.GitHubUsersService
import com.kck.studydikoin.core.providers.GitHubProviders
import com.kck.studydikoin.core.providers.GitHubUsersDataProviders
import com.kck.studydikoin.core.repositories.GitHubUsersRepositoryImpl
import com.kck.studydikoin.core.repositories.IGitHubUsersRepository
import okhttp3.HttpUrl.Companion.toHttpUrl
import org.koin.dsl.bind
import org.koin.dsl.module

val gitHubModule = module {
    single { GitHubUsersRepositoryImpl(get()) } bind IGitHubUsersRepository::class
    single { GitHubUsersDataProviders(get()) } bind GitHubProviders::class
    single {
        RetrofitBuilder.create(URL_GIT_HUB.toHttpUrl())
            .create(GitHubUsersService::class.java)
    } bind GitHubUsersService::class
}