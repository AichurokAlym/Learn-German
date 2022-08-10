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

    /**
     * der ViewHolder weiß welche Teile des Layouts beim Recycling angepasst werden
     */
    class ItemViewHolder(private val view: View) : RecyclerView.ViewHolder(view) {
        val imgView = view.findViewById<ImageView>(R.id.list_image)
        val tvAdjektive = view.findViewById<TextView>(R.id.tvAdjektive)
    }

    /**
     * hier werden neue ViewHolder erstellt
     */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        // das itemLayout wird gebaut
        val adapterLayout = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_adjektive, parent, false)

        // und in einem ViewHolder zurückgegeben
        return ItemViewHolder(adapterLayout)
    }

    /**
     * hier findet der Recyclingprozess statt
     * die vom ViewHolder bereitgestellten Parameter erhalten die Information des Listeneintrags
     */
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {

        val item = dataset[position]

        val imgUri = item.image.toUri().buildUpon().scheme("http").build()

        holder.imgView.load(imgUri) {
            error(R.drawable.ic_round_cloud_off_24)
            transformations(RoundedCornersTransformation(10f))
        }

        holder.tvAdjektive.text = item.adjektiv
    }

    /**
     * damit der LayoutManager weiß, wie lang die Liste ist
     */
    override fun getItemCount(): Int {
        return dataset.size
    }
}