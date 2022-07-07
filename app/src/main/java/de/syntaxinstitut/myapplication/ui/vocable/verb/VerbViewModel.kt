package de.syntaxinstitut.myapplication.ui.vocable.verb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.syntaxinstitut.myapplication.data.VerbRepository

class VerbViewModel(application: Application) : AndroidViewModel(application){

    val verbRepository = VerbRepository()

    val verbList = verbRepository.loadVerbs()

}