package de.syntaxinstitut.myapplication.ui.vocable.adjektive

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import de.syntaxinstitut.myapplication.data.model.Adjektive
import kotlinx.coroutines.delay

class AdjektivRepository(

    private val api: AdjektiveApi
) {

    private val _imageList = MutableLiveData<List<Adjektive>>()
    val imageList: LiveData<List<Adjektive>>
        get() = _imageList

    suspend fun getImages() {
        _imageList.value = api.retrofitService.getImages()
    }
}