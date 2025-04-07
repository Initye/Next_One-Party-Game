package com.example.next_one

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.Bundle
import android.os.LocaleList
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import androidx.navigation.compose.rememberNavController
import com.example.next_one.ui.NextApp
import com.example.next_one.ui.theme.Next_OneTheme
import androidx.navigation.compose.composable
import androidx.navigation.compose.NavHost
import com.example.next_one.LanguageUtils.getSavedLanguage
import com.example.next_one.LanguageUtils.setLanguage
import com.example.next_one.ui.NextAppStartingScreen
import com.example.next_one.ui.AboutScreen
import com.example.next_one.ui.HowToPlay
import com.example.next_one.ui.SettingsScreen
import java.util.Locale


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        val languageCode = getSavedLanguage(this)?: "en"
        setLanguage(this, languageCode)

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

//    Ensures that updated locale are passed before any UI components are created
    override fun attachBaseContext(context: Context) {
        val languageCode = getSavedLanguage(context) ?: "en"
        val newContext = LanguageUtils.wrapContextWithLanguage(context, languageCode)
        super.attachBaseContext(newContext)
    }
}