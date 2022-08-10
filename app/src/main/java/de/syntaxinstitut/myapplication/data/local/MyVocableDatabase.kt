package de.syntaxinstitut.myapplication.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import de.syntaxinstitut.myapplication.data.model.MyVocable
import de.syntaxinstitut.myapplication.data.model.Quiz

//gibt an, dass diese Klasse eine Datenbank ist mit der Tabelle MyVocable und sich in der Version 1 befindet
@Database(entities = [MyVocable::class], version = 1)
abstract class MyVocableDatabase : RoomDatabase(){

    //verknüpft die Datenbank mit dem DAO Interface
    abstract val myVocableDatabaseDao: MyVocableDatabaseDao

}
private lateinit var INSTANCE: MyVocableDatabase

//Erstellt eine neue Datenbank wenn noch keine in INSTANCE gespeichert wurde
//Somit wird sichergestellt dass es nur eine einzige Datenbank gibt
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