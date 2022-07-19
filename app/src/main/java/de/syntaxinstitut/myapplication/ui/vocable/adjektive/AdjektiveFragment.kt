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

    private val viewModel: AdjektiveViewModel by viewModels()

    private lateinit var binding: FragmentAdjektiveBinding

    lateinit var adapter: AdjektiveAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentAdjektiveBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageList = binding.imageList

        imageList.setHasFixedSize(true)

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