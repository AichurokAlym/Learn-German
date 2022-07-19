package de.syntaxinstitut.myapplication.ui.vocable.adjektive

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.core.net.toUri
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.RoundedCornersTransformation
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.Adjektive

class AdjektiveAdapter(
    private val dataset: List<Adjektive>
) : RecyclerView.Adapter<AdjektiveAdapter.ItemViewHolder>() {

    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imgView = view.findViewById<ImageView>(R.id.list_image)
        val tvAdjektive = view.findViewById<TextView>(R.id.tvAdjektive)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_adjektive, parent, false)

        return ItemViewHolder(adapterLayout)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = dataset[position]

        val imgUri = item.image.toUri().buildUpon().scheme("http").build()

        holder.imgView.load(imgUri) {
            error(R.drawable.ic_round_cloud_off_24)
            transformations(RoundedCornersTransformation(10f))
        }

        holder.tvAdjektive.text = item.adjektiv
    }

    override fun getItemCount(): Int {
        return dataset.size
    }
}