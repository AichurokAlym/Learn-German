package de.syntaxinstitut.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.get
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.NavigationUI
import de.syntaxinstitut.myapplication.databinding.FragmentHomeBinding
import de.syntaxinstitut.myapplication.ui.MainViewModel


class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding

    private val viewModel: MainViewModel by activityViewModels()

    private lateinit var userMail: String

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_home, container, false
        )

        // Der LifecycleOwner wird zugewiesem, damit LiveData automatisch vom Layout beobachtet wird
        binding.lifecycleOwner = this.viewLifecycleOwner

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                print("#####"+it)
                if (it == null) {
                    findNavController().navigate(R.id.signInFragment)
                } else {
                    userMail = it.email.toString()
                    binding.tvVocableLearn.text = "$userMail"
                }
            }
        )

       /* binding.logoutButton.setOnClickListener {
            viewModel.logout()
        }*/

        binding.btNomen.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionMenuFragmentToVocabularyFragment())
        }

        binding.btVerb.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToVerbFragment())

        }

        binding.btMyQuestions.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMyQuiz())
        }

        binding.btMyVocableBox.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToMyVocableBox())
        }

        binding.btAdjektive.setOnClickListener {
            findNavController().navigate(HomeFragmentDirections.actionHomeFragmentToAdjektiveFragment())
        }

        binding.btQuiz.setOnClickListener {
            val menuitem = (activity as MainActivity).binding.bottomNavigation.menu.get(2)
            NavigationUI.onNavDestinationSelected(menuitem, findNavController())
        }
    }
}