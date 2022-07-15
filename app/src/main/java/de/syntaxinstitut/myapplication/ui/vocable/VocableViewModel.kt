package de.syntaxinstitut.myapplication.ui.vocable

import android.app.Application
import android.graphics.Color
import android.text.style.BackgroundColorSpan
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.AndroidViewModel
import com.google.android.material.card.MaterialCardView
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

    private  var _tvWord: View? = null
    val tvWord: View?
    get() = _tvWord


    fun setCurrentSelected(view: View, cardView: View, correctArtikel: String, word: View){
        _currentSelectedArtikelTV = view
        _currentSelected = cardView
        _correctArtikel = correctArtikel
        _tvWord = word
    }

    fun changeColor(artikel: String, tvColor: String, cvBackgroundColor: String) {
        try {
            val tv = _currentSelectedArtikelTV as TextView
            tv.text = artikel
            tv.setTextColor(Color.parseColor(tvColor))
            tv.visibility = View.VISIBLE

            val tvWord = _tvWord as TextView
            tvWord.setTextColor(Color.parseColor(tvColor))

            val cv = _currentSelected as MaterialCardView
            cv.setCardBackgroundColor(Color.parseColor(cvBackgroundColor))

        } catch (e: Exception) {
            Log.e ("AAA", e.toString())
        }

    }
}
