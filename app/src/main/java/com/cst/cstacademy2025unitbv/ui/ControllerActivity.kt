package com.cst.cstacademy2025unitbv.ui

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.splashscreen.SplashScreen
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.cst.cstacademy2025unitbv.R
import com.cst.cstacademy2025unitbv.managers.SharedPrefsManager
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class ControllerActivity : AppCompatActivity() {

    private lateinit var splashScreen: SplashScreen
    private var isAppInit: Boolean = false

    private val navController by lazy {
        val host = supportFragmentManager
            .findFragmentById(R.id.nav_host_fragment_activity_main)
                as? NavHostFragment
            ?: error("NavHostFragment not found in layout")
        host.navController
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        setupSplashScreen()

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_controller)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        handleUserStatus()
    }

    private fun handleUserStatus() {
        lifecycleScope.launch {
            val isTokenPresent = withContext(Dispatchers.IO) {
                delay(3000)

                checkAuthToken()
            }

            when (isTokenPresent) {
                true -> setupHomeNavigation()
                false -> setupAuthenticationNavigation()
            }

            isAppInit = true
        }
    }

    private fun checkAuthToken(): Boolean {
        return !SharedPrefsManager.getAuthToken().isNullOrEmpty()
    }

    private fun setupAuthenticationNavigation() {
        navController.setGraph(R.navigation.authentication_navigation)
    }

    private fun setupHomeNavigation() {
        navController.setGraph(R.navigation.home_navigation)
    }

    private fun setupSplashScreen() {
        splashScreen = installSplashScreen().apply {
            this.setKeepOnScreenCondition {
                !isAppInit
            }

            this.setOnExitAnimationListener {
                it.remove()
            }
        }
    }
}