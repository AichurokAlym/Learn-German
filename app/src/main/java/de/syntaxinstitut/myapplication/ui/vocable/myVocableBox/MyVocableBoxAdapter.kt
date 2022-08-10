package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatImageButton
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.MyVocable

/**
 * Diese Klasse organisiert mithilfe der ViewHolder Klasse das Recycling
 */
class MyVocableBoxAdapter(
    private val dataset: List<MyVocable>,
    private val currentSelected: (MyVocable) -> Unit
) : RecyclerView.Adapter<MyVocableBoxAdapter.ItemViewHolder>() {

    /**
     * der ViewHolder umfasst die View uns stellt einen Listeneintrag dar
     */
    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvMyVocableBox: TextView = itemView.findViewById(R.id.tvMyVocableBox)
        val tvMyTranslate: TextView = itemView.findViewById(R.id.tvMyTranslate)
        val btEdit: AppCompatImageButton = itemView.findViewById(R.id.btEdit)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_my_vocable, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.tvMyVocableBox.text = item.newWord
        holder.tvMyTranslate.text = item.newWordsTranslate

        holder.btEdit.setOnClickListener {
            currentSelected(item)
            holder.view.findNavController().navigate(MyVocableBoxDirections.actionMyVocableBoxToMyVocableEdit())
        }

    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }

}