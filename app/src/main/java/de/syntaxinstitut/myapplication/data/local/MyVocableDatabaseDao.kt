package de.syntaxinstitut.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntaxinstitut.myapplication.data.model.Quiz

@Dao
interface MyVocableDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(myVocable: Quiz)

    @Update
    suspend fun update(myVocable: Quiz)

    @Query("SELECT * FROM MyVocable WHERE id = :key ORDER BY question")
    fun getById(key: Long): LiveData<Quiz>

    @Query("DELETE FROM MyVocable WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM MyVocable")
    suspend fun deleteAll()
}