package com.example.guardianchangeapp.welcome

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface AuthAppRepository {
    fun signIn(userName: String, password: String)
    fun registration(userName: String, password: String, email: String)

}

class AuthAppRepositoryImpl(private val application: Application) : AuthAppRepository {

    private val firebaseAuth = FirebaseAuth.getInstance()
    private var userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()
    private var loggedOutLiveData: MutableLiveData<Boolean> = MutableLiveData()

    init {
        if (firebaseAuth.currentUser != null) {
            userLiveData.postValue(firebaseAuth.currentUser)
            loggedOutLiveData.postValue(false)
        }
    }

    override fun signIn(userName: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(application.mainExecutor) { task ->
            if (task.isSuccessful) {
                userLiveData.postValue(firebaseAuth.currentUser)
            } else {
                Toast.makeText(application.applicationContext, "Registration Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    override fun registration(userName: String, password: String, email: String) {

    }

}


