package com.example.guardianchangeapp.welcome.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

interface AuthAppRepository {
    fun login(email: String, password: String)
    fun register(email: String, password: String)

}

class AuthAppRepoImpl(private val application: Application) : AuthAppRepository {
    private var firebaseAuth = FirebaseAuth.getInstance()
    private var _userLiveData: MutableLiveData<FirebaseUser> = MutableLiveData()
    val userLiveData: LiveData<FirebaseUser> = _userLiveData
    private var _loggedOutLiveData: MutableLiveData<Boolean> = MutableLiveData()
    val loggedOutLiveData: LiveData<Boolean> = _loggedOutLiveData

    override fun login(email: String, password: String) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(application.mainExecutor, { task ->
                    if (task.isSuccessful) {
                        _userLiveData.postValue(firebaseAuth.currentUser)
                    } else {
                        Toast.makeText(application.applicationContext, "Login Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    override fun register(email: String, password: String) {
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.P) {
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(application.mainExecutor, { task ->
                    if (task.isSuccessful) {
                        _userLiveData.postValue(firebaseAuth.currentUser)
                    } else {
                        Toast.makeText(application.applicationContext, "Registration Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
                    }
                })
        }
    }

    fun logOut() {
        firebaseAuth.signOut()
        _loggedOutLiveData.postValue(true)
    }

    init {
        if (firebaseAuth.currentUser != null) {
            _userLiveData.postValue(firebaseAuth.currentUser)
            _loggedOutLiveData.postValue(false)
        }
    }
}