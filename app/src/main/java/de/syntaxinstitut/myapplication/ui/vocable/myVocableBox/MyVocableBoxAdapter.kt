package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R

class MyVocableBoxAdapter() : RecyclerView.Adapter<MyVocableBoxAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvMyVocableBox: TextView = itemView.findViewById(R.id.tvMyVocableBox)
        val tvMyTranslate: TextView = itemView.findViewById(R.id.tvMyTranslate)
        val addNewWord: TextView = itemView.findViewById(R.id.addNewWord)
        val addTranslate: TextView = itemView.findViewById(R.id.addTranslate)
        val btEdit: Button = itemView.findViewById(R.id.btEdit)
        val btSave: Button = itemView.findViewById(R.id.btSave)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_my_vocable, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }

}