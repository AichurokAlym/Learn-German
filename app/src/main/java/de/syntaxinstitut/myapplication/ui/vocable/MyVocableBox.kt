package de.syntaxinstitut.myapplication.ui.vocable

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import de.syntaxinstitut.myapplication.R


/**
 * A simple [Fragment] subclass.
 * Use the [MyVocableBox.newInstance] factory method to
 * create an instance of this fragment.
 */
class MyVocableBox : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_vocable_box, container, false)
    }

}