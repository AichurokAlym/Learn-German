package de.syntaxinstitut.myapplication.ui.vocable.verb

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import de.syntaxinstitut.myapplication.data.VerbRepository

class VerbViewModel(application: Application) : AndroidViewModel(application){

    // hier wird eine AppRepository Instanz erstellt
    val verbRepository = VerbRepository()

    //hier werden Verben aus dem Repository geladen.
    val verbList = verbRepository.loadVerbs()

}