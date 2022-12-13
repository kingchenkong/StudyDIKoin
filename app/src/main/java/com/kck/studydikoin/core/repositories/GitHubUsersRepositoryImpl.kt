package com.kck.studydikoin.core.repositories

import com.kck.studydikoin.core.domain.GitHubUser
import com.kck.studydikoin.core.providers.GitHubUsersDataProviders

class GitHubUsersRepositoryImpl(
    private val gitHubUsersDataProviders: GitHubUsersDataProviders
) : IGitHubUsersRepository {
    override suspend fun getGitHubUsers(): Result<GitHubUser> {
        return gitHubUsersDataProviders.getGitHubUsers()
    }
}