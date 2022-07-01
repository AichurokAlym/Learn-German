package de.syntaxinstitut.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import de.syntaxinstitut.myapplication.databinding.ActivityMainBinding

/**
 * Main Activity, dient als Einstiegspunkt für die App
 */
class MainActivity : AppCompatActivity() {

    // hier wird das binding deklariert
     lateinit var binding: ActivityMainBinding

    // Hier wird der Navigation Controller des gesamten Projektes deklariert
    private lateinit var navController: NavController
    /* -------------------- Lifecycle -------------------- */

    /**
     * Lifecycle Methode, wird aufgerufen wenn Activity erstellt wird
     *
     * @param savedInstanceState      Save state vom view
     */
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Das Binding zur XML-Datei
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Die Navigationsleiste am unteren Bildschirmrand wird eingerichtet
        val navView: BottomNavigationView = binding.bottomNavigation

        // Hier wird der Nav Controller zugewiesen und die Action Bar damit eingerichtet
        navController = findNavController(R.id.nav_host_fragment)

        // Richtet die Navigation Bar ein, sodass sie mit dem Nav Controller verknüpft ist
        navView.setupWithNavController(navController)
    }

    /**
     * Diese Funktion sorgt dafür, dass man über den zurück Button in der Actionbar zurück kommt
     */
    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp() || super.onSupportNavigateUp()
    }
}
