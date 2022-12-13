package com.kck.studydikoin.core.network.service

import com.google.gson.JsonObject
import com.kck.studydikoin.core.network.ROUTER_SELF
import com.kck.studydikoin.core.network.ROUTER_USERS
import retrofit2.Response
import retrofit2.http.GET

interface GitHubUsersService {

    @GET("/$ROUTER_USERS/$ROUTER_SELF")
    suspend fun getGitHubUsers(): Response<JsonObject>
}