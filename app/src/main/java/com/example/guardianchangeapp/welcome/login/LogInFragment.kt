package com.example.guardianchangeapp.welcome.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import com.example.guardianchangeapp.MainActivity
import com.example.guardianchangeapp.databinding.FragmentLogInBinding
import com.google.firebase.auth.FirebaseUser


class LogInFragment : Fragment() {
    private lateinit var logInBinding: FragmentLogInBinding
    private val loginRegViewModel: LogInRegViewModel by viewModels()
    private lateinit var currentUser: LiveData<FirebaseUser>
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return logInBinding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        currentUser = loginRegViewModel.getUserLiveData()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeFocus()
        clickOnLoginButReg()
    }

    private fun clickOnLoginButReg() {
        logInBinding.logIn.setOnClickListener {
            if (logInBinding.loginEmailEt.text.toString().isNotEmpty() && logInBinding.loginPassEt.text.toString().isNotEmpty()) {
                loginRegViewModel.sigIn(logInBinding.loginEmailEt.text.toString(), logInBinding.loginPassEt.text.toString())
                if (currentUser.value?.email == logInBinding.loginEmailEt.text.toString()) {
                    val sectionIntent = Intent(requireActivity(), MainActivity::class.java)
                    startActivity(sectionIntent)
                    requireActivity().finish()
                } else {
                    logInBinding.loginEmailLayout.error = "Please write correct email"
                }
            } else if (logInBinding.loginPassEt.text.toString().isEmpty() || logInBinding.loginEmailEt.text.toString().isEmpty()) {
                logInBinding.loginPassLayout.error = "Please write  password"
                logInBinding.loginEmailLayout.error = "Please write  email"
            } else {
                Toast.makeText(requireContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun changeFocus() {
        logInBinding.loginEmailEt.setOnFocusChangeListener { view, isFocus ->
            if (isFocus)
            logInBinding.loginEmailLayout.isErrorEnabled = false

        }
        logInBinding.loginPassEt.setOnFocusChangeListener { view, isFocus ->
            if (isFocus)
            logInBinding.loginPassLayout.isErrorEnabled = false

        }
    }
}