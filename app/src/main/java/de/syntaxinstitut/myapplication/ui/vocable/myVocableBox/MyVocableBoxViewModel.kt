package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import de.syntaxinstitut.myapplication.data.local.getDatabase
import de.syntaxinstitut.myapplication.data.model.MyVocable
import kotlinx.coroutines.launch

class MyVocableBoxViewModel(application: Application) : AndroidViewModel(application) {

    private val database = getDatabase(application)

    // hier wird eine AppRepository Instanz erstellt, mit dem Parameter database
    private val myVRepository = MyVocableBoxRepository(database)

    // hier werden die vocableList aus dem repository in einer eigenen Variablen gespeichert
    val vocableList = myVRepository.vocableList

    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean>
        get() = _complete

    private val _selectedVocable = MutableLiveData<MyVocable>()
    val selectedVocable: LiveData<MyVocable>
        get() = _selectedVocable

    //wird neue wörter hinzugefügt
    fun insertVocable(myVocable: MyVocable) {
        viewModelScope.launch {
            myVRepository.insert(myVocable)
            _complete.value = true
        }
    }

    //mit dieser Funktion wird Wörter aktualisiert
    fun updateVocable(myVocable: MyVocable) {
        viewModelScope.launch {
            myVRepository.update(myVocable)
            _complete.value = true
        }
    }

    //mit dieser Funktion wird Wörter aus der Liste gelöscht
    fun deleteVocable(myVocable: MyVocable) {
        viewModelScope.launch {
            myVRepository.delete(myVocable)
            _complete.value = true
        }
    }

    fun unsertComplete() {
        _complete.value = false
    }

    fun currentSelected(item: MyVocable) {
        _selectedVocable.value = item
    }
}