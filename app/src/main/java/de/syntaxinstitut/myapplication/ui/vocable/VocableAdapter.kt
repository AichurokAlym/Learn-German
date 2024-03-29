package de.syntaxinstitut.myapplication.ui.vocable

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
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
) : RecyclerView.Adapter<VocableAdapter.ItemViewHolder>() {


    // der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvArtikel: TextView = itemView.findViewById(R.id.tvArtikel)
        val tvWord: TextView = itemView.findViewById(R.id.tvWord)
        val tvTranslate: TextView = itemView.findViewById(R.id.tvTranslate)
        val tvExampleSentence: TextView = itemView.findViewById(R.id.tvExsampleSentence)
        val cvCardView: MaterialCardView = itemView.findViewById(R.id.materialCardView)
        var showTranslate: Boolean = false
        val btDer: Button = itemView.findViewById(R.id.btDer)
        val btDas: Button = itemView.findViewById(R.id.btDas)
        val btDie: Button = itemView.findViewById(R.id.btDie)

    }

    // hier werden neue ViewHolder erstellt
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_vocable, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(itemLayout)
    }

    // hier findet der Recyclingprozess statt
    // die vom ViewHolder bereitgestellten Parameter werden verändert
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val vocable = dataset[position]

        holder.tvWord.text = vocable.word
        holder.tvTranslate.text = vocable.wordsTranslate
        holder.tvExampleSentence.text = vocable.exampleSentence

        holder.btDer.text = "der"
        holder.btDas.text = "das"
        holder.btDie.text = "die"


        if(!vocable.isClickt) {
            holder.cvCardView.setBackgroundColor(Color.parseColor("#EDE7F6"))
            holder.tvArtikel.visibility = View.INVISIBLE
            holder.tvWord.setBackgroundColor(Color.parseColor("#EDE7F6"))
        }

        //mit animate Funktion wird sich cvCardView umdrehen
        // und übersetzung des Wortes wird angezeigt
        holder.cvCardView.setOnClickListener {
            it.animate()
                .rotationYBy(180f)
                .setDuration(200)
                .withEndAction {
                    if (holder.showTranslate) {
                        holder.tvTranslate.visibility = View.GONE
                        holder.tvWord.visibility = View.VISIBLE
                        holder.tvArtikel.visibility = View.VISIBLE
                    } else {
                        holder.tvTranslate.visibility = View.VISIBLE
                        holder.tvArtikel.visibility = View.INVISIBLE
                        holder.tvWord.visibility = View.GONE
                        holder.tvTranslate.rotationY = 180f
                        holder.tvTranslate.setTextColor(holder.tvArtikel.currentTextColor)
                    }
                    holder.showTranslate = !holder.showTranslate
                }
        }

        //jedes Wort hat drei ArtikelButtons, damit wird der Richtige Artikel ausgewählt
        holder.btDer.setOnClickListener {
            checkArtikel (dataset[position].artikel, holder.btDer, holder.cvCardView, holder.tvArtikel, holder.tvWord)
            vocable.isClickt = true
        }

        holder.btDas.setOnClickListener {
            checkArtikel (dataset[position].artikel, holder.btDas, holder.cvCardView, holder.tvArtikel, holder.tvWord)
            vocable.isClickt = true
        }

        holder.btDie.setOnClickListener {
            checkArtikel (dataset[position].artikel, holder.btDie, holder.cvCardView, holder.tvArtikel, holder.tvWord)
            vocable.isClickt = true
        }


    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }

    //mit checkArtikel Funktion wird die Farbe von der CarView und TextView entsprechend verändert.
    fun checkArtikel(correctArtikel: String, artikelButton: Button, cv: MaterialCardView, tvArtikel: TextView, tv: TextView) {
        if (correctArtikel == artikelButton.text) {
           val color = artikelButton.background as ColorDrawable
            val tvColor = artikelButton.currentTextColor

            cv.setBackgroundColor(color.color)
            tvArtikel.text = correctArtikel
            tvArtikel.setBackgroundColor(color.color)
            tvArtikel.setTextColor(tvColor)
            tvArtikel.visibility = View.VISIBLE

            tv.setBackgroundColor(color.color)
            tv.setTextColor(tvColor)
        } else {
            tvArtikel.text = "versuche es nochmal!"
            cv.setBackgroundColor(Color.parseColor("#EDE7F6"))
            tvArtikel.setTextColor(Color.parseColor("#000000"))
            tv.setTextColor(Color.parseColor("#000000"))
            tvArtikel.setBackgroundColor(Color.parseColor("#EDE7F6"))
            tv.setBackgroundColor(Color.parseColor("#EDE7F6"))
        }
    }

}