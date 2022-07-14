package de.syntaxinstitut.myapplication.data.local

import androidx.lifecycle.LiveData
import androidx.room.*
import de.syntaxinstitut.myapplication.data.model.Quiz

@Dao
interface QuizDatabaseDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(quiz: Quiz)

    @Update
    suspend fun update(quiz: Quiz)

    @Query("SELECT * FROM Quiz WHERE id = :key ORDER BY question")
    fun getById(key: Long): LiveData<Quiz>

    @Query("DELETE FROM Quiz WHERE id = :id")
    suspend fun deleteById(id: Long)

    @Query("DELETE FROM Quiz")
    suspend fun deleteAll()
}