package com.example.guardianchangeapp.welcome.login

import android.app.Application
import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class AuthAppRepository(private val application: Application) {
    private lateinit var firebaseAuth: FirebaseAuth
    val userLiveData: MutableLiveData<FirebaseUser>
    val loggedOutLiveData: MutableLiveData<Boolean>

    fun login(email: String?, password: String?) {
        firebaseAuth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor, { task ->
                if (task.isSuccessful) {
                    userLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Toast.makeText(application.applicationContext, "Login Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

    fun register(email: String?, password: String?) {
        firebaseAuth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener(application.mainExecutor, { task ->
                if (task.isSuccessful) {
                    userLiveData.postValue(firebaseAuth.currentUser)
                } else {
                    Toast.makeText(application.applicationContext, "Registration Failure: " + task.exception!!.message, Toast.LENGTH_SHORT).show()
                }
            })
    }

    fun logOut() {
        firebaseAuth.signOut()
        loggedOutLiveData.postValue(true)
    }

    init {
        firebaseAuth = FirebaseAuth.getInstance()
        userLiveData = MutableLiveData()
        loggedOutLiveData = MutableLiveData()
        if (firebaseAuth.currentUser != null) {
            userLiveData.postValue(firebaseAuth.currentUser)
            loggedOutLiveData.postValue(false)
        }
    }
}
//class LoginRegisterViewModel(application: Application) : AndroidViewModel(application) {
//    private val authAppRepository: AuthAppRepository
//    val userLiveData: MutableLiveData<FirebaseUser>
//
//    fun login(email: String?, password: String?) {
//        authAppRepository.login(email, password)
//    }
//
//    fun register(email: String?, password: String?) {
//        authAppRepository.register(email, password)
//    }
//
//    init {
//        authAppRepository = AuthAppRepository(application)
//        userLiveData = authAppRepository.getUserLiveData()
//    }
//}