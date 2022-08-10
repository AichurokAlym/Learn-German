package de.syntaxinstitut.myapplication.ui.vocable.verb

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Verb

class VerbAdapter(private val dataset: List<Verb>): RecyclerView.Adapter<VerbAdapter.ItemViewHolder>()  {

    //der ItemViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val infinitiv: TextView = itemView.findViewById(R.id.tvInfinitiv)
        val präsens: TextView = itemView.findViewById(R.id.tvPräsens)
        val präteritum: TextView = itemView.findViewById(R.id.tvPrateritum)
        val hilfsVerb: TextView = itemView.findViewById(R.id.tvHilfsVerb)
        val cvInfinitiv: CardView = itemView.findViewById(R.id.cv_infinitiv)
        val cvPräsens: CardView = itemView.findViewById(R.id.cv_präsens)
        val cvPräteritum: CardView = itemView.findViewById(R.id.cv_präteritum)
        val cvHilfsVerb: CardView = itemView.findViewById(R.id.cv_hilfsVerb)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        // das itemLayout wird gebaut
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_verben, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(itemLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: VerbAdapter.ItemViewHolder, position: Int) {

        // hier wird Verben aus dem dataset geholt
        val verb = dataset[position]

        if(position%2 == 0) {
            holder.cvInfinitiv.setBackgroundColor(Color.parseColor("#FFEDE7F6"))
            holder.cvPräsens.setBackgroundColor(Color.parseColor("#FFEDE7F6"))
            holder.cvPräteritum.setBackgroundColor(Color.parseColor("#FFEDE7F6"))
            holder.cvHilfsVerb.setBackgroundColor(Color.parseColor("#FFEDE7F6"))
        }

        holder.infinitiv.text = verb.infinitiv
        holder.präsens.text = verb.präsens
        holder.präteritum.text = verb.präteritum
        holder.hilfsVerb.text = verb.hilfsVerb

    }

    // damit der LayoutManager weiß wie lang die Liste ist
    override fun getItemCount(): Int {
        return dataset.size
    }
}