package de.syntaxinstitut.myapplication.ui.vocable

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.syntaxinstitut.myapplication.data.VocableRepository

/**
 * Das ViewModel des One Fragments
 */
class VocableViewModel(application: Application) : AndroidViewModel(application) {

    /* -------------------- Klassen Variablen -------------------- */
	
    val vRepository = VocableRepository()

    val vocableList = vRepository.loadVocabularies()


    /**
     * Mit dieser Funktion wird der Trigger ausgelöst um zum zweiten Fragment zu wechseln
     */
    fun navigateToFragmentTwo() {
       // navigateToFragmentTwo.value = true
    }

    /**
     * Setzt alle Werte der Variablen auf ihren "Werkszustand" zurück
     */
    fun resetAllValues() {
       // navigateToFragmentTwo.value = false
    }
}
