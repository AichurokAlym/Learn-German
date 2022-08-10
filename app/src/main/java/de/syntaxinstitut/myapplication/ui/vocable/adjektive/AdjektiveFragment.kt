package de.syntaxinstitut.myapplication.ui.vocable.adjektive

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.myapplication.databinding.FragmentAdjektiveBinding


class AdjektiveFragment : Fragment() {

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: AdjektiveViewModel by viewModels()

    // Das binding für das QuizFragment wird deklariert
    private lateinit var binding: FragmentAdjektiveBinding

    lateinit var adapter: AdjektiveAdapter

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdjektiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = binding.imageList

        imageList.setHasFixedSize(true)

        //wird Images von der Api geladen
        viewModel.images.observe(
            viewLifecycleOwner,
            Observer {
                if (this::adapter.isInitialized) {
                    adapter.notifyDataSetChanged()
                } else {
                    adapter = AdjektiveAdapter(it)
                    binding.imageList.adapter = adapter
                }
            }
        )

        //loading liefert ApiStatus zurück
        viewModel.loading.observe(
            viewLifecycleOwner,
            Observer {
                when (it) {
                    ApiStatus.LOADING -> binding.progressBar.visibility = View.VISIBLE
                    ApiStatus.DONE -> binding.progressBar.visibility = View.GONE
                    ApiStatus.ERROR -> {
                        binding.progressBar.visibility = View.GONE
                        binding.errorImage.visibility = View.VISIBLE
                    }
                }
            }
        )
    }
}