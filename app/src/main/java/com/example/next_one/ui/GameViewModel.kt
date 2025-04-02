package com.example.next_one.ui

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.next_one.data.allWordsEnglish
import com.example.next_one.data.allWordsPolish
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue

class GameViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()
    var language by mutableStateOf("English")

    fun updateLanguage(newLanguage: String) {
        language = newLanguage
        pickRandomText()
    }

    fun pickRandomText(): String {
        val currentText = if(language == "Polish") allWordsPolish.random() else allWordsEnglish.random()

        _uiState.value = GameUiState(currentText = currentText)
        return currentText
    }
}