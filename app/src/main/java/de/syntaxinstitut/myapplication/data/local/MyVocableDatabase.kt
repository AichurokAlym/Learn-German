package de.syntaxinstitut.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.myapplication.data.model.Quiz

@Database(entities = [Quiz::class], version = 1)
abstract class MyVocableDatabase : RoomDatabase(){

    abstract val quizDatabaseDao: MyVocableDatabaseDao

}
private lateinit var INSTANCE: MyVocableDatabase

fun getDatabase(context: Context): MyVocableDatabase {
    synchronized(MyVocableDatabase::class.java) {
        if (!::INSTANCE.isInitialized) {
            INSTANCE = Room.databaseBuilder(
                context.applicationContext,
                MyVocableDatabase::class.java,
                "my_vocable_database"
            )
                .build()
        }
    }
    return INSTANCE
}