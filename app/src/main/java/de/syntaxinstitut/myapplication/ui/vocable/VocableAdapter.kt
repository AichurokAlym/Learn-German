package de.syntaxinstitut.myapplication.ui.vocable

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.card.MaterialCardView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Vocable


class VocableAdapter(
    private val dataset: List<Vocable>,
    private val selectCallBack: (View,View, String) -> Unit
) : RecyclerView.Adapter<VocableAdapter.ItemViewHolder>() {


    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvArtikel: TextView = itemView.findViewById(R.id.tvArtikel)
        val tvWord: TextView = itemView.findViewById(R.id.tvVocableBox)
        val tvTranslate: TextView = itemView.findViewById(R.id.tvTranslate)
        val tvExampleSentence: TextView = itemView.findViewById(R.id.tvExsampleSentence)
        val cvCardView: MaterialCardView = itemView.findViewById(R.id.materialCardView)
        var showTranslate: Boolean = false
        val radioButton: Button = itemView.findViewById(R.id.radioButton)

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

        holder.cvCardView.setOnClickListener {
            it.animate()
                .rotationYBy(180f)
                .setDuration(200)
                .withEndAction {
                    if (holder.showTranslate) {
                        holder.tvTranslate.visibility = View.GONE
                        holder.tvWord.visibility = View.VISIBLE
                        holder.tvArtikel.visibility = View.INVISIBLE
                    } else {
                        holder.tvTranslate.visibility = View.VISIBLE
                        holder.tvArtikel.visibility = View.INVISIBLE
                        holder.tvWord.visibility = View.GONE
                        holder.tvTranslate.rotationY = 180f
                    }
                    holder.showTranslate = !holder.showTranslate
                }
        }

        holder.radioButton.setOnClickListener {
            selectCallBack(holder.tvArtikel, holder.cvCardView, vocable.artikel)
        }


    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}