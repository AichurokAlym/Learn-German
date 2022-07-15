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
    private val myVRepository = MyVocableBoxRepository(database)

    val vocableList = myVRepository.vocableList

    private val _complete = MutableLiveData<Boolean>()
    val complete: LiveData<Boolean>
        get() = _complete

    fun insertVocable(myVocable: MyVocable) {
        viewModelScope.launch {
            myVRepository.insert(myVocable)
            _complete.value = true
        }
    }

    fun updateVocable(myVocable: MyVocable) {
        viewModelScope.launch {
            myVRepository.update(myVocable)
            _complete.value = true
        }
    }

    fun deleteVocable(myVocable: MyVocable) {
        viewModelScope.launch {
            myVRepository.delete(myVocable)
            _complete.value = true
        }
    }

    fun unsertComplete() {
        _complete.value = false
    }
}