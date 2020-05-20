package com.kprights.medchords

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.kprights.infosys.newsfeed.viewmodel.AppViewModel

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)

        val navController = findNavController(R.id.nav_host_fragment)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        val appBarConfiguration = AppBarConfiguration(setOf(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications))
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)

        val appViewModel = AppViewModel()

        appViewModel.response.observe(this,
            Observer { t -> Toast.makeText(this@MainActivity, t, Toast.LENGTH_SHORT).show() })

        appViewModel.postTextOnButton("B1")
        appViewModel.postTextOnButton("B2")
        appViewModel.postTextOnButton("B3")
        appViewModel.postTextOnButton("B4")
        appViewModel.postTextOnButton("Random")
        appViewModel.postTextOnButton("")



    }
}
