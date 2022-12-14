package com.kck.studydikoin.core.providers

import android.util.Log
import com.google.gson.Gson
import com.google.gson.JsonObject
import com.kck.studydikoin.core.domain.GitHubUser
import com.kck.studydikoin.core.network.service.GitHubUsersService
import retrofit2.Response

class GitHubUsersDataProviders(
    private val gitHubUsersService: GitHubUsersService
) : GitHubProviders {
    private val TAG: String = GitHubUsersDataProviders::class.java.simpleName

    override suspend fun getGitHubUsers(): Result<GitHubUser> {
        val response: Response<JsonObject> = gitHubUsersService.getGitHubUsers()
//        logResponse(response)

        return when {
            response.isSuccessful -> {
                val gson = Gson()
                val ghu:GitHubUser = gson.fromJson(response.body()!!, GitHubUser::class.java)
                Result.success(ghu)
            }
            else -> {
                Result.failure(Exception())
            }
        }
    }

    private fun logResponse(response: Response<JsonObject>) {
        try {
            Log.d(TAG, "getGitHubUsers: isSuccessful: \n${response.isSuccessful}")
            Log.d(TAG, "getGitHubUsers: code: \n${response.code()}")
            Log.d(TAG, "getGitHubUsers: message: \n${response.message()}")
            Log.d(TAG, "getGitHubUsers: header: \n${response.headers()}")
            Log.d(TAG, "getGitHubUsers: body: \n${response.body()}")
            Log.d(TAG, "getGitHubUsers: errorBody: \n${response.errorBody()}")
        } catch (exception: Exception) {
            Log.d(TAG, "getGitHubUsers: exception: \n $exception")
        }
    }
}