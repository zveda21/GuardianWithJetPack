package com.example.guardianchangeapp

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.common.ApiClient
import com.example.common.BaseCommonViewModel
import com.example.common.CommonRepositoryImpl
import com.example.guardianchangeapp.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    lateinit var controller: NavController
    private var commonRepositoryImpl = CommonRepositoryImpl(ApiClient.instance)
    private val commonViewModel by viewModels<BaseCommonViewModel> {
        MainFactory(commonRepositoryImpl)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        commonViewModel.getCurrentSection()
        setupViews()
        getSection()
    }

    private fun setupViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentsNavHost) as NavHostFragment
        controller = navHostFragment.navController
        NavigationUI.setupWithNavController(mainBinding.bottomNavigation, controller)
    }

    private fun getSection() {
        commonViewModel.getSection.observe(this, Observer {
            Log.e("Data", it.toString())
        })
    }
}