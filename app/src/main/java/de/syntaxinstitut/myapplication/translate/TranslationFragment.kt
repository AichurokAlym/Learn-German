package de.syntaxinstitut.myapplication.translate

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import de.syntaxinstitut.myapplication.databinding.FragmentTranslationBinding

class TranslationFragment : Fragment() {

    private lateinit var binding: FragmentTranslationBinding

    //bei mehreren Fragmenten actyvityViewModels
    private val viewModel: TranslateViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentTranslationBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tvTranslation.addTextChangedListener {
            if (!it!!.equals("")) {
                viewModel.loadTranslate(it.toString())
            }
        }

        viewModel.translation.observe(
            viewLifecycleOwner,
            Observer {
                binding.tvTranslate.text = it.data.translations[0].translatedText.replace("%20", " ")
            }
        )
    }

}