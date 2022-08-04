package de.syntaxinstitut.myapplication.translate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class TranslateRepository(private val translateApi: TranslationApi) {

    private val _translation = MutableLiveData<TranslateData>()
    val translation: LiveData<TranslateData>
        get() = _translation


    //q = query (übersetzende Wort)
    suspend fun translate(q: String) {
        try {
            val query = q.replace(" ", "%20")
            _translation.value = translateApi.retrofitService.translate(query, "en", "de")
        } catch (e: Exception) {
            Log.e("AAA", e.toString())
        }

    }
}