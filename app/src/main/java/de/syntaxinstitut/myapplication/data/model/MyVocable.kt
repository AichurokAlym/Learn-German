package de.syntaxinstitut.myapplication.data.model

import android.text.Editable
import android.widget.EditText
import androidx.room.Entity
import androidx.room.PrimaryKey
//@Entity - gibt an, dass aus dieser Klasse eine Tabelle für die Datenbank generiert werden kann
@Entity
data class MyVocable(
    //@PrimaryKey - gibt an dass die nachfolgende Variable als Primärschlüssel dient
    @PrimaryKey(autoGenerate = true)
    val id: Long,
    var newWord: String,
    var newWordsTranslate: String
){
}