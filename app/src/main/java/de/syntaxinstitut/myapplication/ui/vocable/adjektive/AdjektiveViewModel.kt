package de.syntaxinstitut.myapplication.ui.vocable.adjektive

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

const val TAG = "AdjektiveViewModel"

enum class ApiStatus { LOADING, ERROR, DONE }

class AdjektiveViewModel : ViewModel() {

    private val repository = AdjektivRepository(AdjektiveApi)

    val images = repository.imageList

    private val _loading = MutableLiveData<ApiStatus>()
    val loading: LiveData<ApiStatus>
        get() = _loading

    init {
        loadData()
    }

    fun loadData() {
        viewModelScope.launch {
            _loading.value = ApiStatus.LOADING
            try {
                repository.getImages()
                _loading.value = ApiStatus.DONE
            } catch (e: Exception) {
                Log.e(TAG, "Error loading Data from API: $e")
                _loading.value = ApiStatus.ERROR
            }
        }
    }
}