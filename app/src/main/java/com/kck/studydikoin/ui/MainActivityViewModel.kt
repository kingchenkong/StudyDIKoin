package com.kck.studydikoin.ui

import android.graphics.BitmapFactory
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kck.studydikoin.core.domain.GitHubUser
import com.kck.studydikoin.core.repositories.IGitHubUsersRepository
import kotlinx.coroutines.launch
import org.koin.core.context.GlobalContext
import org.koin.experimental.property.inject

class MainActivityViewModel : ViewModel() {
    private val TAG: String = MainActivityViewModel::class.java.simpleName

    private val gitHubUsersRepository: IGitHubUsersRepository by GlobalContext.get().inject()
//    private val gitHubUsersRepository: IGitHubUsersRepository by getKoin().get()

    val gitHubUsersLiveData: MutableLiveData<GitHubUser> = MutableLiveData<GitHubUser>()

    //    lateinit var mGitHubUser: GitHubUser
    var mGitHubUser: GitHubUser = GitHubUser.toEmpty()

    fun getGitHubUsers() {
        Log.e(TAG, "getGitHubUsers: ")
        viewModelScope.launch {
            gitHubUsersRepository.getGitHubUsers().getOrNull().runCatching {
                gitHubUsersLiveData.postValue(this)
            }
        }
    }

}