package com.kck.studydikoin.ui

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import com.kck.studydikoin.R
import com.kck.studydikoin.databinding.ActivityMainBinding

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
        viewModel.gitHubUsersJsonObject.observe(this) {
            Log.e(TAG, "initObserver: $it")
            viewBinding.tvJson.text = it.toString()
        }
    }

    private fun getGitHubUsers() {
        viewModel.getGitHubUsers()
//        val gitHubUser: GitHubUser = viewModel.gitHubUsersJsonObject.value!!
//        Log.e(TAG, "getGitHubUsers: \n$gitHubUser")
    }
}