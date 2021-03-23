package com.example.guardianchangeapp.welcome.register

import android.os.Bundle
import android.util.Patterns
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.guardianchangeapp.MainActivity
import com.example.guardianchangeapp.base.BaseLoginRegFragment
import com.example.guardianchangeapp.databinding.FragmentRegisterBinding
import com.example.guardianchangeapp.welcome.WelcomeActivity
import com.example.guardianchangeapp.welcome.login.LogInRegViewModel


class RegisterFragment : BaseLoginRegFragment() {
    private lateinit var registerBinding: FragmentRegisterBinding
    private val loginRegisterViewModel: LogInRegViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        registerBinding = FragmentRegisterBinding.inflate(inflater, container, false)
        return registerBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        changeFocus()
        onclickRegBtn()
    }

    private fun onclickRegBtn() {
        registerBinding.registerBtn.setOnClickListener {
            if (registerBinding.regEmailEt.text.toString().isNotEmpty() &&
                Patterns.EMAIL_ADDRESS.matcher(registerBinding.regEmailEt.text.toString())
                    .matches() && registerBinding.regPassEt.text.toString().isNotEmpty()
            ) {
                loginRegisterViewModel.register(registerBinding.regEmailEt.text.toString(), registerBinding.regPassEt.text.toString())
                val activity = requireActivity() as WelcomeActivity
                activity.startMainActivity(MainActivity())
            } else if (registerBinding.regEmailEt.text.toString().isEmpty() || registerBinding.regPassEt.text.toString().isEmpty()) {
                registerBinding.regEmailLayout.error = "Please write  email"
                registerBinding.regPassLayout.error = "Please write  password"
            } else if (!Patterns.EMAIL_ADDRESS.matcher(registerBinding.regEmailEt.text.toString()).matches()) {
                registerBinding.regEmailLayout.error = "Please write correct email"
            } else {
                Toast.makeText(requireContext(), "Reg failure", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun changeFocus() {
        registerBinding.regEmailEt.setOnFocusChangeListener { view, isFocus ->
            if (isFocus)
            registerBinding.regEmailLayout.isErrorEnabled = false

        }
        registerBinding.regPassEt.setOnFocusChangeListener { view, isFocus ->
            if (isFocus)
            registerBinding.regPassLayout.isErrorEnabled = false

        }
    }

}