package com.example.next_one.ui

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.next_one.data.allWordsEnglish
import com.example.next_one.data.allWordsPolish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import com.example.next_one.LanguageUtils
import com.example.next_one.data.matureWordsEnglish
import com.example.next_one.data.matureWordsPolish

class GameViewModel(): ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    fun pickRandomText(): String {
        val wordsCombinedPolish  = allWordsPolish + matureWordsPolish
        val wordsCombinedEnglish  = allWordsEnglish + matureWordsEnglish

        val currentText = when {
            LanguageUtils.currentLanguage.value == "pl" && LanguageUtils.matureContentEnabled.value ->
                wordsCombinedPolish.random()
            LanguageUtils.currentLanguage.value == "en" && LanguageUtils.matureContentEnabled.value ->
                wordsCombinedEnglish.random()
            LanguageUtils.currentLanguage.value == "en" ->
                allWordsEnglish.random()
            else ->
                allWordsPolish.random()
        }

        _uiState.value = GameUiState(currentText = currentText)
        return currentText
    }
}


