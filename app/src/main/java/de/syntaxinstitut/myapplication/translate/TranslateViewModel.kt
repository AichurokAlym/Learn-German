package de.syntaxinstitut.myapplication.translate

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class TranslateViewModel : ViewModel() {

    // Eine Instanz (ein Objekt) des Repository wird erstellt und gepeichert
    val repository = TranslateRepository(TranslationApi)

    //hier wird Informationen aus dem Repository gespeichert
    val translation = repository.translation

    /**
     * Diese Funktion ruft die Repository-Funktion zum Laden des Wörters
     * innerhalb einer Coroutine auf
     */
    fun loadTranslate(q: String) {
        viewModelScope.launch {
            repository.translate(q)

        }
    }
}