package de.syntaxinstitut.myapplication.ui.vocable

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
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


    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
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

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //recyclerView von Layout wird mit code verknüpft
        val recyclerView = binding.rvVocable

        //VocableAdapter wird als Adapter festgelegt
        recyclerView.adapter = VocableAdapter(viewModel.vocableList)

       /* recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            var scrollDy = 0
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
             val lm = recyclerView.layoutManager!! as LinearLayoutManager
               //lm.findViewByPosition(lm.findFirstVisibleItemPosition())

               viewModel.setCurrentCardView(lm.findViewByPosition(lm.findFirstVisibleItemPosition())!!)
                viewModel.currentSelected!!.setBackgroundColor(Color.GREEN)

            }

            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                scrollDy += dy
            }
        })*/

        /*binding.btDer.setOnClickListener {
          if(viewModel.correctArtikel == "der") {
              viewModel.changeColor("der", "#FFFFFF", "#000000" )

          } else {
              viewModel.changeColor("versuche es nochmal!", "#000000", "#EDE7F6")
          }
        }

        binding.btDie.setOnClickListener {
            if (viewModel.correctArtikel == "die") {
                viewModel.changeColor("die", "#000000", "#F43535")

            } else {
                viewModel.changeColor("versuche es nochmal!", "#000000", "#EDE7F6")
            }
        }

        binding.btDas.setOnClickListener {
            if (viewModel.correctArtikel == "das") {
                viewModel.changeColor("das", "#000000", "#E8E04F")

            } else {
                viewModel.changeColor("versuche es nochmal!", "#000000", "#EDE7F6")

            }
        }*/
    }

    /*fun selectCallBack(view: View, cardView: View, correctArtikel: String, word: View) {
        viewModel.setCurrentSelected(view, cardView, correctArtikel, word )

    }*/

}
