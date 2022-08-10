package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.util.Log
import androidx.lifecycle.LiveData
import de.syntaxinstitut.myapplication.data.local.MyVocableDatabase
import de.syntaxinstitut.myapplication.data.model.MyVocable

const val TAG = "MyVocableRepository"

class MyVocableBoxRepository(private val database: MyVocableDatabase) {

    //Speichert das Ergebnis der getAll() Anfrage des DAO
    val vocableList: LiveData<List<MyVocable>> = database.myVocableDatabaseDao.getAll()

    //Fügt mittels der insert Funktion des DAO ein neues Vocable in die Datenbank ein.
    suspend fun insert(myVocable: MyVocable) {
        try {
            database.myVocableDatabaseDao.insert(myVocable)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to insert into Database: $e")
        }
    }

    //zum aktualisieren
    suspend fun update(myVocable: MyVocable) {
        try {
            database.myVocableDatabaseDao.update(myVocable)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to update Database: $e")
        }
    }

    //zum löschen
    suspend fun delete(myVocable: MyVocable){
        try {
            database.myVocableDatabaseDao.deleteById(myVocable.id)
        } catch (e: Exception) {
            Log.e(TAG, "Failed to delete from Database: $e")
        }
    }
}