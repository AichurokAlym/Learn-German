package de.syntaxinstitut.myapplication.translate

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

/**
 * Diese Klasse holt die Informationen und stellt sie mithilfe von Live Data dem Rest
 * der App zur Verfügung
 */
class TranslateRepository(private val translateApi: TranslationApi) {

    private val _translation = MutableLiveData<TranslateData>()
    val translation: LiveData<TranslateData>
        get() = _translation


    /**
     * Diese Funktion ruft die Daten aus dem API Service ab und speichert die Antwort in der
     * Variable imageList.
     */
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