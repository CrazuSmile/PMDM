package com.juanjosesanz.taskmanager.tasks.ui.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.juanjosesanz.taskmanager.model.preferences.AppPreferences
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class OnBoardingTaskViewModel(application: Application) : AndroidViewModel(application) {
    val context = application

    private val _username = MutableLiveData<String>()
    val username: LiveData<String> = _username

    fun onUsernameChange(username: String) {
        _username.value = username
    }

    fun saveUsername(username: String) {
        viewModelScope.launch(Dispatchers.IO) {
            AppPreferences.saveUsernameValue(context, username)
        }
    }
}

// 1º _username <- 2º username <- 3º inputUsername