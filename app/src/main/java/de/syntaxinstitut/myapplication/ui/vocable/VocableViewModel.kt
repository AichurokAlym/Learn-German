package de.syntaxinstitut.myapplication.ui.vocable

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import de.syntaxinstitut.myapplication.data.VocableRepository

/**
 * Das ViewModel des One Fragments
 */
class VocableViewModel(application: Application) : AndroidViewModel(application) {


    val vRepository = VocableRepository()
    val vocableList = vRepository.loadVocabularies()


    private var _currentSelectedArtikelTV: View? = null
    val currentSelectedArtikelTv: View?
    get() = _currentSelectedArtikelTV

    private var _currentSelected: View? = null
    val currentSelected: View?
        get() = _currentSelected

     private var _correctArtikel: String = ""
    val correctArtikel: String
    get() = _correctArtikel

    private  var _tvWord: String = ""


    fun setCurrentSelected(view: View, cardView: View, correctArtikel: String, word: String){
        _currentSelectedArtikelTV = view
        _currentSelected = cardView
        _correctArtikel = correctArtikel
    }


}
