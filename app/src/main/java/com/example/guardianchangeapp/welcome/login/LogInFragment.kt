package com.example.guardianchangeapp.welcome.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.guardianchangeapp.MainActivity
import com.example.guardianchangeapp.databinding.FragmentLogInBinding


class LogInFragment : Fragment() {
    private lateinit var logInBinding: FragmentLogInBinding
    private val loginRegViewModel: LogInRegViewModel by viewModels()
    private lateinit var username: String
    private lateinit var password: String
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return logInBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        clickOnLoginButReg()
    }

    fun clickOnLoginButReg() {
        logInBinding.logIn.setOnClickListener {
            if (logInBinding.userName.text.toString().isNotEmpty() && logInBinding.password.text.toString().isNotEmpty()) {
                loginRegViewModel.sigIn(logInBinding.userName.text.toString(), logInBinding.password.text.toString())
                val sectionIntent = Intent(requireActivity(),MainActivity::class.java)
                startActivity(sectionIntent)
                requireActivity().finish()
            } else {
                Toast.makeText(requireContext(), "Email Address and Password Must Be Entered", Toast.LENGTH_SHORT).show()
            }
        }
        logInBinding.userName.editableText.clear()
        logInBinding.password.editableText.clear()

    }
}