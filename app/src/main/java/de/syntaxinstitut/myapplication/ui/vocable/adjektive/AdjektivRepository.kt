package de.syntaxinstitut.myapplication.ui.vocable.adjektive

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.myapplication.data.model.Adjektive
import kotlinx.coroutines.delay

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class AdjektivRepository(
    private val api: AdjektiveApi
) {

    private val _imageList = MutableLiveData<List<Adjektive>>()
    val imageList: LiveData<List<Adjektive>>
        get() = _imageList

    /**
     * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
     * Variable imageList.
     */
    suspend fun getImages() {
        _imageList.value = api.retrofitService.getImages()
    }
}