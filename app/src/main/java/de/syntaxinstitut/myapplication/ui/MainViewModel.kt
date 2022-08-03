package de.syntaxinstitut.myapplication.ui

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

const val TAG = "MAINVIEWMODEL"

class MainViewModel(application: Application) : AndroidViewModel(application){

    // Kommunikationspunkt mit der FirebaseAuth
    private val firebaseAuth = FirebaseAuth.getInstance()

    // currentuser ist null wenn niemand eingeloggt ist
    private val _currentUser = MutableLiveData<FirebaseUser?>(firebaseAuth.currentUser)
    val currentUser: LiveData<FirebaseUser?>
        get() = _currentUser

    // hier wird versucht einen User zu erstellen um diesen anschließend auch gleich
    // einzuloggen
    fun signUp(email: String, password: String) {
        firebaseAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener {
            if (it.isSuccessful) {
                login(email, password)
                print("signup erfolgreich")
            } else {
                Log.e(TAG, "SignUp failed: ${it.exception}")
            }
        }
    }

    fun login(email: String, password: String) {
        print("abcd")
        firebaseAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener {
            print("abcd")
            if (it.isSuccessful) {
                print("abcd")
                _currentUser.value = firebaseAuth.currentUser
            } else {
                Log.e(TAG, "Login feiled: ${it.exception}")
            }
        }
    }

    fun logout() {
        firebaseAuth.signOut()
        _currentUser.value = firebaseAuth.currentUser
    }
}


