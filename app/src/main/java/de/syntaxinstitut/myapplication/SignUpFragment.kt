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
import de.syntaxinstitut.myapplication.databinding.FragmentSignUpBinding
import de.syntaxinstitut.myapplication.ui.MainViewModel

class SignUpFragment : Fragment() {

    /** Das ViewModel zu diesem Fragment */
    private val viewModel: MainViewModel by activityViewModels()

    /** Bindet das XML-View mit der Klasse um auf die Elemente zugreifen zu können */
    private lateinit var binding: FragmentSignUpBinding

    /**
     * Lifecycle Funktion onCreateView
     * Hier wird das binding initialisiert und das Layout gebaut
     */
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_sign_up, container, false)

        return binding.root
    }

    /**
     * Lifecycle Funktion onViewCreated
     * Hier werden die Elemente eingerichtet und z.B. onClickListener gesetzt
     */
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.signin.setOnClickListener {
            findNavController().navigate(SignUpFragmentDirections.actionSignUpFragmentToSignInFragment())
        }

        binding.btnSignup.setOnClickListener {
            signUp()
        }

        viewModel.currentUser.observe(
            viewLifecycleOwner,
            Observer {
                if (it != null) {
                    findNavController().navigate(R.id.homeFragment)
                }
            }
        )
    }

    private fun signUp() {
        val email = binding.mail.text.toString()
        val password = binding.password.text.toString()

        if (!email.isNullOrEmpty() && !password.isNullOrEmpty()) {
            viewModel.signUp(email, password)
        }
    }
}

