package com.example.guardianchangeapp.nestedfragments.firstTab

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.guardianchangeapp.R
import com.example.guardianchangeapp.databinding.FragmentSectionBinding


class SectionFragment : Fragment() {
    private lateinit var sectionBinding: FragmentSectionBinding

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
    }

}