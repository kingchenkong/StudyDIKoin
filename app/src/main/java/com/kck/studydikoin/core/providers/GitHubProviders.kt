package com.kck.studydikoin.core.providers

import com.kck.studydikoin.core.domain.GitHubUser

interface GitHubProviders {
    suspend fun getGitHubUsers(): Result<GitHubUser>
}