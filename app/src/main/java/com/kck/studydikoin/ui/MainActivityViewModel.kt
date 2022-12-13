package com.kck.studydikoin.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kck.studydikoin.core.domain.GitHubUser
import com.kck.studydikoin.core.repositories.IGitHubUsersRepository
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext

class MainActivityViewModel : ViewModel() {
    private val TAG: String = MainActivityViewModel::class.java.simpleName

    private val gitHubUsersRepository: IGitHubUsersRepository by GlobalContext.get().inject()
//    private val gitHubUsersRepository: IGitHubUsersRepository by getKoin().get()

    private val _gitHubUsersJsonObject: MutableLiveData<GitHubUser> = MutableLiveData<GitHubUser>()
    val gitHubUsersJsonObject: LiveData<GitHubUser> = _gitHubUsersJsonObject

    fun getGitHubUsers() {
        viewModelScope.launch {
            gitHubUsersRepository.getGitHubUsers().getOrNull().runCatching {
                _gitHubUsersJsonObject.postValue(this)
            }
        }
    }
}