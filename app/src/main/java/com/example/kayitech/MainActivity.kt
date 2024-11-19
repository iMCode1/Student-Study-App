package com.example.kayitech

import android.graphics.Color
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupWithNavController
import com.example.kayitech.databinding.ActivityMainBinding
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.snackbar.Snackbar
import com.github.mikephil.charting.charts.LineChart
import com.github.mikephil.charting.data.Entry
import com.github.mikephil.charting.data.LineData
import com.github.mikephil.charting.data.LineDataSet
import com.example.kayitech.R
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    lateinit var binding: ActivityMainBinding
    private lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Inflate the layout using view binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Set up the toolbar and enable the app bar configuration
        setSupportActionBar(binding.toolbar)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        // Set up the navigation controller
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        appBarConfiguration = AppBarConfiguration(
            setOf(R.id.dashboard_page, R.id.quizzes_page, R.id.flashcards_page, R.id.wishlist_page,
                R.id.leaderboard_page, R.id.settings_page)
        )
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Initialize the DrawerLayout
        drawerLayout = binding.drawerLayout
        val navView: NavigationView = binding.navView

        navView.setupWithNavController(navController)

        // Set up the menu icon click listener to toggle the DrawerLayout
        val menuIcon: View = binding.toolbar.findViewById(R.id.menuIcon)
        menuIcon.setOnClickListener {
            if (drawerLayout.isDrawerOpen(findViewById(R.id.nav_view))) {
                drawerLayout.closeDrawer(findViewById(R.id.nav_view))
            } else {
                drawerLayout.openDrawer(findViewById(R.id.nav_view))
            }
        }

        navView.setNavigationItemSelectedListener { menuItem ->
            // Handle menu item clicks here
            when (menuItem.itemId) {
                R.id.nav_dashboard -> {
                    // Navigate to dashboard fragment
                    navController.navigate(R.id.dashboard_page)
                }
                R.id.nav_quizzes -> {
                    // Navigate to quizzes fragment
                    navController.navigate(R.id.quizzes_page)
                }
                R.id.nav_flashcards -> {
                    // Navigate to flashcards fragment
                    navController.navigate(R.id.flashcards_page)
                }
                R.id.nav_wishlist -> {
                    // Navigate to flashcards fragment
                    navController.navigate(R.id.wishlist_page)
                }
                R.id.nav_leaderboard -> {
                    // Navigate to flashcards fragment
                    navController.navigate(R.id.leaderboard_page)
                }

            }
            drawerLayout.closeDrawer(GravityCompat.START) // Close the drawer
            true
        }

        val bottomNavView = binding.root.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        bottomNavView?.setupWithNavController(navController)

        bottomNavView.setOnItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.home -> {
                    navController.navigate(R.id.dashboard_page) // Update with the correct destination ID
                    true
                }
                R.id.settings -> {
                    navController.navigate(R.id.settings_page) // Reference the settings destination
                    true
                }

                else -> false
            }
        }


        // Set up the FloatingActionButton (FAB) onClickListener
        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null)
                .setAnchorView(R.id.fab).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        menu.findItem(R.id.settings)?.isVisible = false
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here
        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_main)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }
}
