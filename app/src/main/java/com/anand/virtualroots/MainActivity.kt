package com.anand.virtualroots

import android.content.pm.ActivityInfo
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.anand.virtualroots.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    var binding: ActivityMainBinding? = null
    var navController: NavController? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val firestoreHelper = FirestoreHelper()
        firestoreHelper.addPlants() // This will add all 17 plants to Firestore

        navController = findNavController(R.id.host)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        binding?.bottomNav?.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.nav_home -> navController?.navigate(R.id.homeFragment)
                R.id.nav_ar -> navController?.navigate(R.id.ARFragment)
                R.id.nav_info -> navController?.navigate(R.id.infoFragment)
                R.id.nav_camera -> navController?.navigate(R.id.cameraFragment)
            }
            return@setOnItemSelectedListener true
        }
    }


}