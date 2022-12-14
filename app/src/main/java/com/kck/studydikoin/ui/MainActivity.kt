package com.kck.studydikoin.ui

import android.graphics.BitmapFactory
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.viewModelScope
import com.bumptech.glide.Glide
import com.kck.studydikoin.R
import com.kck.studydikoin.core.domain.GitHubUser
import com.kck.studydikoin.databinding.ActivityMainBinding
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import org.koin.android.ext.android.bind

class MainActivity : AppCompatActivity() {
    private val TAG: String = MainActivity::class.java.simpleName

    private val viewModel: MainActivityViewModel by viewModels()
    private lateinit var viewBinding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        viewBinding.lifecycleOwner = this

        initObserver()
        getGitHubUsers()
    }

    private fun initObserver() {
        viewModel.gitHubUsersLiveData.observe(this) {
            Log.e(TAG, "initObserver: $it")
            setUI(it)
//            viewModel.mGitHubUser = it
//            setAvatar(it)
        }
    }

    private fun getGitHubUsers() {
        viewModel.getGitHubUsers()
    }

    private fun setUI(gitHubUser: GitHubUser) {
        viewBinding.let {
            it.tvName.text = gitHubUser.name
            it.tvEmail.text = if (gitHubUser.email == null) {
                ""
            } else {
                gitHubUser.email.toString()
            }
            it.tvUrl.text = gitHubUser.url
            it.tvLocation.text = gitHubUser.location
        }
    }

    private fun setAvatar(gitHubUser: GitHubUser) {
        Log.e(TAG, "setAvatar: ")
            Glide.with(this)
                .load(gitHubUser.avatar_url)
                .into(viewBinding.ivAvatar)
    }
}