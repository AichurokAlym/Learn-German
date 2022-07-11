package de.syntaxinstitut.myapplication.ui.vocable

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.google.android.material.card.MaterialCardView
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.databinding.FragmentVocableBinding

/**
 * Fragment 1
 */
class VocableFragment : Fragment() {

    /* -------------------- Klassen Variablen -------------------- */

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentVocableBinding

    /** Das ViewModel zu diesem Fragment */
    private val viewModel: VocableViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_vocable, container, false)

        // Der LifecycleOwner wird zugewiesem, damit LiveData automatisch vom Layout beobachtet wird
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val recyclerView = binding.rvVocable

        recyclerView.adapter = VocableAdapter(viewModel.vocableList, ::selectCallBack)

        binding.btDer.setOnClickListener {
          if(viewModel.correctArtikel == "der") {
              val tv = viewModel.currentSelectedArtikelTv as TextView
              tv.text = "der"
              tv.setTextColor(Color.parseColor("#FFFFFF"))
              tv.visibility = View.VISIBLE

              val tvWord =

              val cv = viewModel.currentSelected as MaterialCardView
              cv.setBackgroundColor(Color.parseColor("#000000"))

          } else {
              val tv = viewModel.currentSelectedArtikelTv as TextView
              tv.text = "versuche es nochmal!"
              tv.visibility = View.VISIBLE

              val cv = viewModel.currentSelected as MaterialCardView
              cv.setBackgroundColor(Color.parseColor("#EDE7F6"))
          }
        }

        binding.btDie.setOnClickListener {
            if (viewModel.correctArtikel == "die") {
                val tv = viewModel.currentSelectedArtikelTv as TextView
                tv.text = "die"
                tv.visibility = View.VISIBLE

                val cv = viewModel.currentSelected as MaterialCardView
                cv.setBackgroundColor(Color.parseColor("#F43535"))

            } else {
                val tv = viewModel.currentSelectedArtikelTv as TextView
                tv.text = "versuche es nochmal!"
                tv.visibility = View.VISIBLE

                val cv = viewModel.currentSelected as MaterialCardView
                cv.setBackgroundColor(Color.parseColor("#EDE7F6"))
            }
        }

        binding.btDas.setOnClickListener {
            if (viewModel.correctArtikel == "das") {
                val tv = viewModel.currentSelectedArtikelTv as TextView
                tv.text = "das"
                tv.visibility = View.VISIBLE

                val cv = viewModel.currentSelected as MaterialCardView
                cv.setBackgroundColor(Color.parseColor("#E8E04F"))

            } else {
                val tv = viewModel.currentSelectedArtikelTv as TextView
                tv.text = "versuche es nochmal!"
                tv.visibility = View.VISIBLE

                val cv = viewModel.currentSelected as MaterialCardView
                cv.setBackgroundColor(Color.parseColor("#EDE7F6"))

            }
        }
    }

    fun selectCallBack(view: View, cardView: View, correctArtikel: String, word: String ) {
        viewModel.setCurrentSelected(view, cardView, correctArtikel, word )

    }

}
