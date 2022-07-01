package de.syntaxinstitut.myapplication.ui.vocable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Vocable

class VocableAdapter( private val dataset: List<Vocable>
) : RecyclerView.Adapter<VocableAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvWord: TextView = itemView.findViewById(R.id.tvVocable)
        val tvTranslate: TextView = itemView.findViewById(R.id.tvTranslate)
        val tvExampleSentence: TextView = itemView.findViewById(R.id.tvExsampleSentence)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_vocable, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val vocable = dataset[position]

        holder.tvWord.text = vocable.word
        holder.tvTranslate.text = vocable.wordsTranslate
        holder.tvExampleSentence.text = vocable.exampleSentence
    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}