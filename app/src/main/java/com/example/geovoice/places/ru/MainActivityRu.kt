package com.example.geovoice.places.ru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.CongradulationsActivity
import com.example.geovoice.R
import com.example.geovoice.databinding.ActivityMainRuBinding

class MainActivityRu : AppCompatActivity() {
    lateinit var binding: ActivityMainRuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityMainRuBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.tv1.setOnClickListener {
            markVisited("place1")
            val intent = Intent(this, FirstPlaceActivityRu::class.java)
            startActivity(intent)
        }
        binding.tv2.setOnClickListener {
            markVisited("place2")
            val intent = Intent(this, SecondPlaceActivityRu::class.java)
            startActivity(intent)
        }
        binding.tv3.setOnClickListener {
            markVisited("place3")
            val intent = Intent(this, ThirdPlaceActivityRu::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()
        checkQuestionCompletion()
    }
    private fun markVisited(key: String){
        val prefs = getSharedPreferences("QuestPrefs", MODE_PRIVATE)
        prefs.edit().putBoolean(key, true).apply()
    }

    private fun checkQuestionCompletion(){
        val prefs = getSharedPreferences("QuestPrefs", MODE_PRIVATE)
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