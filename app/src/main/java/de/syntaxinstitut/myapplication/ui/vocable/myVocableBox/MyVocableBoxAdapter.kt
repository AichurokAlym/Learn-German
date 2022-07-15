package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.MyVocable

class MyVocableBoxAdapter(
    private val dataset: List<MyVocable>
) : RecyclerView.Adapter<MyVocableBoxAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(val view: View) : RecyclerView.ViewHolder(view) {
        val tvMyVocableBox: TextView = itemView.findViewById(R.id.tvMyVocableBox)
        val tvMyTranslate: TextView = itemView.findViewById(R.id.tvMyTranslate)
        val btEdit: Button = itemView.findViewById(R.id.btEdit)

        val addNewWord: TextView = itemView.findViewById(R.id.addNewWord)
        val addTranslate: TextView = itemView.findViewById(R.id.addTranslate)
       // val btSave: Button = itemView.findViewById(R.id.btSave)


    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_my_vocable, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]
        holder.tvMyVocableBox.text = item.newWord
        holder.tvMyTranslate.text = item.newWordsTranslate

        holder.btEdit.setOnClickListener {
            holder.view.findNavController().navigate(MyVocableBoxDirections.actionMyVocableBoxToMyVocableEdit())
        }

    }

    override fun getItemCount(): Int {
        return dataset.size
    }

}