package com.example.next_one

import android.app.LocaleManager
import android.content.Context
import android.os.Build
import android.os.LocaleList
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.os.LocaleListCompat
import android.app.Activity
import android.util.Log
import java.util.Locale

object LanguageUtils {
    fun getSavedLanguage(context: Context): String? {
        val sharedPreferences = context.getSharedPreferences("language_prefs", Context.MODE_PRIVATE)
        return sharedPreferences.getString("language", null)
    }

    fun setLanguage(context: Context, languageCode: String) {
        Log.d("LanguageUtils", "Setting language to: $languageCode")
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            context.getSystemService(LocaleManager::class.java)
                .applicationLocales = LocaleList.forLanguageTags(languageCode)
        } else {
            AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags(languageCode))
        }

        saveLanguage(context, languageCode)
    }

    fun saveLanguage(context: Context, languageCode: String) {
        val sharedPreferences = context.getSharedPreferences("language_prefs", Context.MODE_PRIVATE)
        sharedPreferences.edit().putString("language", languageCode).apply()
    }

    //Apply new locale to Context
    fun wrapContextWithLanguage(context: Context, languageCode: String): Context {
        val locale = Locale(languageCode)
        Locale.setDefault(locale)

        val config = context.resources.configuration
        config.setLocale(locale)

        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            context.createConfigurationContext(config)
        } else {
            context.resources.updateConfiguration(config, context.resources.displayMetrics)
            context
        }
    }
}
