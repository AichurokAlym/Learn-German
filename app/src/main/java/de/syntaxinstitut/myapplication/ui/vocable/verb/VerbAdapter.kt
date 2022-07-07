package de.syntaxinstitut.myapplication.ui.vocable.verb

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Verb

class VerbAdapter(private val dataset: List<Verb>): RecyclerView.Adapter<VerbAdapter.ItemViewHolder>()  {

    inner class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val infinitiv: TextView = itemView.findViewById(R.id.tvInfinitiv)
        val präsens: TextView = itemView.findViewById(R.id.tvPräsens)
        val präteritum: TextView = itemView.findViewById(R.id.tvPrateritum)
        val hilfsVerb: TextView = itemView.findViewById(R.id.tvHilfsVerb)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ItemViewHolder {
        val itemLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_verben, parent, false)

        return ItemViewHolder(itemLayout)
    }

    override fun onBindViewHolder(holder: VerbAdapter.ItemViewHolder, position: Int) {

        val verb = dataset[position]

        holder.infinitiv.text = verb.infinitiv
        holder.präsens.text = verb.präsens
        holder.präteritum.text = verb.präteritum
        holder.hilfsVerb.text = verb.hilfsVerb
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}