package com.example.geovoice

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.databinding.ActivityMainBinding
import com.example.geovoice.places.CongradulationsActivity
import com.example.geovoice.places.FirstPlaceActivity
import com.example.geovoice.places.SecondPlaceActivity
import com.example.geovoice.places.ThirdPlaceActivity

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tv1.setOnClickListener {
            markVisited("place1")
            val intent = Intent(this, FirstPlaceActivity::class.java)
            startActivity(intent)
        }
        binding.tv2.setOnClickListener {
            markVisited("place2")
            val intent = Intent(this, SecondPlaceActivity::class.java)
            startActivity(intent)
        }
        binding.tv3.setOnClickListener {
            markVisited("place3")
            val intent = Intent(this, ThirdPlaceActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        checkQuestionCompletion()
    }
    private fun markVisited(key: String){
        val prefs = getSharedPreferences("QuestPrefs", Context.MODE_PRIVATE)
        prefs.edit().putBoolean(key, true).apply()
    }

    private fun checkQuestionCompletion(){
        val prefs = getSharedPreferences("QuestPrefs", Context.MODE_PRIVATE)
        val p1 = prefs.getBoolean("place1", false)
        val p2 = prefs.getBoolean("place2", false)
        val p3 = prefs.getBoolean("place3", false)
        if (p1 && p2 && p3){
            val intent = Intent(this, CongradulationsActivity::class.java)
            startActivity(intent)
            prefs.edit().clear().apply()
                finish()
        }
    }

}