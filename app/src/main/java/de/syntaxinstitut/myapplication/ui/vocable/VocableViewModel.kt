package de.syntaxinstitut.myapplication.ui.vocable

import android.app.Application
import android.view.View
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.card.MaterialCardView
import de.syntaxinstitut.myapplication.data.VocableRepository

/**
 * Das ViewModel des One Fragments
 */
class VocableViewModel(application: Application) : AndroidViewModel(application) {


    val vRepository = VocableRepository()

    val vocableList = vRepository.loadVocabularies()

    private var _currentSelected: View? = null
    val currentSelected: View?
    get() = _currentSelected


     private var _correctAnswer: String = ""
    val correctAnswer: String
    get() = _correctAnswer



    fun setCurrentSelected(view: View, correctAnswer: String){
        _currentSelected = view
        _correctAnswer = correctAnswer
    }


}
