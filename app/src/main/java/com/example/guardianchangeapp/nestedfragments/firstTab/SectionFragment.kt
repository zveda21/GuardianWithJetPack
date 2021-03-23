package com.example.guardianchangeapp.nestedfragments.firstTab

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.fragment.findNavController
import com.example.guardianchangeapp.R
import com.example.guardianchangeapp.databinding.FragmentSectionBinding
import com.example.guardianchangeapp.welcome.WelcomeActivity
import com.example.guardianchangeapp.welcome.login.LogInRegViewModel


class SectionFragment : Fragment() {
    private lateinit var sectionBinding: FragmentSectionBinding
    private val logInRegViewModel:LogInRegViewModel by viewModels()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        sectionBinding = FragmentSectionBinding.inflate(inflater, container, false)
        return sectionBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        sectionBinding.click.setOnClickListener {
            findNavController().navigate(R.id.action_sectionFragment_to_contentFragment)
        }
        signOutFromSection()
    }
    private fun signOutFromSection(){
        sectionBinding.signOutBtn.setOnClickListener {
            logInRegViewModel.logOut()
            val welcomeIntent = Intent(requireActivity(),WelcomeActivity::class.java)
            requireActivity().startActivity(welcomeIntent)
            requireActivity().finish()
        }
    }

}