package de.syntaxinstitut.myapplication.translate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TranslateViewModel : ViewModel() {

    val repository = TranslateRepository(TranslationApi)

    val translation = repository.translation

    fun loadTranslate(q: String) {
        viewModelScope.launch {
            repository.translate(q)

        }
    }
}