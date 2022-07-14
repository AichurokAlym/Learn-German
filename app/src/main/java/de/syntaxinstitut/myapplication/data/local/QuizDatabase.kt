package de.syntaxinstitut.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.myapplication.data.model.Quiz

@Database(entities = [Quiz::class], version = 1)
abstract class QuizDatabase : RoomDatabase(){

    abstract val quizDatabaseDao: QuizDatabaseDao

}
private lateinit var INSTANCE: QuizDatabase

fun getDatabase(context: Context): QuizDatabase {
    synchronized(QuizDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                QuizDatabase::class.java,
                "quiz_database"
            )
                .build()
        }
    }
    return INSTANCE
}