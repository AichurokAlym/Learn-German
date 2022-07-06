package de.syntaxinstitut.myapplication.ui.vocable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
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
          if(viewModel.correctAnswer == "der") {
              val tv = viewModel.currentSelected as TextView
              tv.text = "der"
              tv.visibility = View.VISIBLE
          } else {
              val tv = viewModel.currentSelected as TextView
              tv.text = "versuch noch mal!"
              tv.visibility = View.VISIBLE
          }
        }

        binding.btDie.setOnClickListener {
            if (viewModel.correctAnswer == "die") {
                val tv = viewModel.currentSelected as TextView
                tv.text = "die"
                tv.visibility = View.VISIBLE
            } else {
                val tv = viewModel.currentSelected as TextView
                tv.text = "versuch noch mal!"
                tv.visibility = View.VISIBLE
            }
        }

        binding.btDas.setOnClickListener {
            if (viewModel.correctAnswer == "das") {
                val tv = viewModel.currentSelected as TextView
                tv.text = "das"
                tv.visibility = View.VISIBLE
                //val cv = viewModel.currentSelected as MaterialCardView
                //cv.setCardBackgroundColor()
            } else {
                val tv = viewModel.currentSelected as TextView
                tv.text = "versuch noch mal!"
                tv.visibility = View.VISIBLE
            }
        }
    }

    fun selectCallBack(view: View, correctAnswer: String) {
        viewModel.setCurrentSelected(view, correctAnswer)

    }

}
