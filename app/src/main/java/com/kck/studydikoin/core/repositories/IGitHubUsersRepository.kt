package com.kck.studydikoin.core.repositories

import com.kck.studydikoin.core.domain.GitHubUser

interface IGitHubUsersRepository {
    suspend fun getGitHubUsers(): Result<GitHubUser>
}