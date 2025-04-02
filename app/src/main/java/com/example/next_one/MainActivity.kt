package com.example.next_one

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.navigation.compose.rememberNavController
import com.example.next_one.ui.NextApp
import com.example.next_one.ui.theme.Next_OneTheme
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.next_one.ui.NextAppStartingScreen
import com.example.next_one.ui.AboutScreen
import com.example.next_one.ui.HowToPlay
import com.example.next_one.ui.SettingsScreen


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val navController = rememberNavController()
            Next_OneTheme {
                NavHost(navController = navController, startDestination = "start_Screen") {
                    composable("start_Screen") {
                        NextAppStartingScreen(navController)
                    }
                    composable("game_Screen") {
                        NextApp()
                    }
                    composable("htp_Screen") {
                        HowToPlay()
                    }
                    composable("about_Screen") {
                        AboutScreen()
                    }
                    composable("settings_Screen") {
                        SettingsScreen()
                    }
                }
//            NextApp()
            }
        }
    }
}