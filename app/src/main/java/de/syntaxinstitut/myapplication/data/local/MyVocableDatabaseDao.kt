package de.syntaxinstitut.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntaxinstitut.myapplication.data.model.MyVocable
import de.syntaxinstitut.myapplication.data.model.Quiz
import de.syntaxinstitut.myapplication.ui.vocable.myVocableBox.MyVocableBox

@Dao
interface MyVocableDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myVocable: MyVocable)

    @Update
    suspend fun update(myVocable: MyVocable)

    @Query("SELECT * FROM MyVocable ORDER BY newWord")
    fun getAll(): LiveData<List<MyVocable>>

    @Query("SELECT * FROM MyVocable WHERE id = :key")
    fun getById(key: Long): LiveData<MyVocable>

    @Query("DELETE FROM MyVocable WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM MyVocable")
    suspend fun deleteAll()
}