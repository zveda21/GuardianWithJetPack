package com.example.guardianchangeapp.welcome

import android.app.Application
import android.os.Build
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface AuthAppRepository {
    fun signIn(userName: String, password: String)
    fun registration(userName: String, password: String)

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

    @RequiresApi(Build.VERSION_CODES.P)
    override fun signIn(userName: String, password: String) {
        firebaseAuth.signInWithEmailAndPassword(userName, password).addOnCompleteListener(application.mainExecutor) { task ->
            if (task.isSuccessful) {
                userLiveData.postValue(firebaseAuth.currentUser)
            } else {
                Toast.makeText(application.applicationContext, "Login  Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
            }
        }
    }

    @RequiresApi(Build.VERSION_CODES.P)
    override fun registration(userName: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(userName, password).addOnCompleteListener(application.mainExecutor) { task ->
            if (task.isSuccessful) {
                userLiveData.postValue(firebaseAuth.currentUser)
            } else {
                Toast.makeText(application.applicationContext, "Registration Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
            }

        }
    }

    fun logOut() {
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }

    fun getFireBaseUser(): MutableLiveData<FirebaseUser> {
        return userLiveData
    }

    fun getLoggedOutLiveData(): MutableLiveData<Boolean> {
        return loggedOutLiveData
    }
}


