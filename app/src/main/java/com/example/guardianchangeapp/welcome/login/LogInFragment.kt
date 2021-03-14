package com.example.guardianchangeapp.welcome.login

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.guardianchangeapp.MainActivity
import com.example.guardianchangeapp.databinding.FragmentLogInBinding
import com.example.guardianchangeapp.welcome.WelcomeActivity


class LogInFragment : Fragment() {
    private lateinit var logInBinding: FragmentLogInBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        logInBinding = FragmentLogInBinding.inflate(inflater, container, false)
        return logInBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        logInBinding.click.setOnClickListener {
            val intent = Intent(requireActivity() as WelcomeActivity, MainActivity::class.java)
            startActivity(intent)
            requireActivity().finish()
            // findNavController().navigate(R.id.action_logInFragment_to_nav_graph)

        }
    }

}