package com.example.guardianchangeapp.welcome.login

import android.app.Application
import androidx.lifecycle.MutableLiveData
import com.example.guardianchangeapp.base.BaseLoginRegViewModel
import com.google.firebase.auth.FirebaseUser

class LogInRegViewModel(application: Application) : BaseLoginRegViewModel(application) {
    private val authAppRepository = AuthAppRepoImpl(application)
    val userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()

    fun sigIn(username: String, password: String) {
        authAppRepository.login(username, password)
    }
    fun register(username: String,password: String){
        authAppRepository.register(username,password)
    }
    @JvmName("getUserLiveData1")
    fun getUserLiveData() : MutableLiveData<FirebaseUser>{
        return userLiveData
    }
}