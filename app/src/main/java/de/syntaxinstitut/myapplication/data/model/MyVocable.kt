package de.syntaxinstitut.myapplication.data.model

import android.text.Editable
import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MyVocable(
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var newWord: String,
    var newWordsTranslate: String
){
}