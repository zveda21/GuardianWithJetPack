package com.example.guardianchangeapp.welcome.login

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseUser

class LogInViewModel(application: Application) : AndroidViewModel(application) {
    private val authAppRepository = AuthAppRepository(application)
    val userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()

    fun sigIn(username: String, password: String) {
        authAppRepository.login(username, password)
    }

}