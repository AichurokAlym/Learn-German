package de.syntaxinstitut.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import de.syntaxinstitut.myapplication.databinding.FragmentMyAccountBinding
import de.syntaxinstitut.myapplication.ui.MainViewModel


class MyAccount: Fragment() {

    // Das Binding zur XML-Datei
  private lateinit var binding: FragmentMyAccountBinding

    // Hier wird das ViewModel, in dem die Logik stattfindet, geholt
  private val viewModel: MainViewModel by activityViewModels()

    private lateinit var userMail: String

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_my_account, container, false
        )
        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it == null) {
                    findNavController().navigate(R.id.signInFragment)
                } else {
                    userMail = it.email.toString()
                    binding.tvName.text = "$userMail"
                }
            }
        )

        binding.mcvMyVocableBox.setOnClickListener {
            findNavController().navigate(MyAccountDirections.actionMyAccount2ToMyVocableBox())
        }

        binding.mcvQuiz.setOnClickListener {
            findNavController().navigate(MyAccountDirections.actionMyAccount2ToMyQuiz())
        }

        binding.btLogout.setOnClickListener {
            viewModel.logout()
        }

    }
}