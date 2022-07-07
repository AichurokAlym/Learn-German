package de.syntaxinstitut.myapplication.ui.vocable

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import com.google.android.material.card.MaterialCardView
import de.syntaxinstitut.myapplication.data.VerbRepository
import de.syntaxinstitut.myapplication.data.VocableRepository

/**
 * Das ViewModel des One Fragments
 */
class VocableViewModel(application: Application) : AndroidViewModel(application) {


    val vRepository = VocableRepository()
    val vocableList = vRepository.loadVocabularies()

    val verbRepository = VerbRepository()
    val verbList = verbRepository.loadVerbs()


    private var _currentSelectedArtikelTV: View? = null
    val currentSelectedArtikelTv: View?
    get() = _currentSelectedArtikelTV

    private var _currentSelected: View? = null
    val currentSelected: View?
        get() = _currentSelected

     private var _correctAnswer: String = ""
    val correctAnswer: String
    get() = _correctAnswer

    fun setCurrentSelected(view: View, cardView: View, correctAnswer: String){
        _currentSelectedArtikelTV = view
        _currentSelected = cardView
        _correctAnswer = correctAnswer
    }


}
