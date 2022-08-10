package de.syntaxinstitut.myapplication.ui.vocable.myVocableBox

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.R
import de.syntaxinstitut.myapplication.data.model.MyVocable
import de.syntaxinstitut.myapplication.databinding.FragmentMyVocableBoxBinding


class MyVocableBox : Fragment() {

    // Das binding für das MyVocableBoxFragment wird deklariert
    private lateinit var binding: FragmentMyVocableBoxBinding

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
    private val viewModel: MyVocableBoxViewModel by activityViewModels()


    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_my_vocable_box, container, false)

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
        val myVocableRV = binding.recyclerView


        viewModel.vocableList.observe(
            viewLifecycleOwner,
            Observer {
                myVocableRV.adapter = MyVocableBoxAdapter(it, ::currentSelectedItem)

            }
        )

        //hier wird zum MyVocableAddFragment navigiert um neue Wörter hinzufügen
        binding.btAddVT.setOnClickListener{
            findNavController().navigate(MyVocableBoxDirections.actionMyVocableBoxToMyVocableAdd())

        }
    }

    fun currentSelectedItem(item: MyVocable) {
        viewModel.currentSelected(item)
    }

}