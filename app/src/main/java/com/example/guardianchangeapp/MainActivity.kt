package com.example.guardianchangeapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.example.guardianchangeapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var mainBinding: ActivityMainBinding
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(mainBinding.root)
        setupViews()

    }

    private fun setupViews() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentsNavHost) as NavHostFragment
        controller = navHostFragment.navController
        val controllerN = findNavController(R.id.fragmentsNavHost)

        //  mainBinding.bottomNavigation.setupWithNavController(controllerN)
        NavigationUI.setupWithNavController(mainBinding.bottomNavigation, controllerN)

    }


}