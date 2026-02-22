package com.example.geovoice.places

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.MainActivity
import com.example.geovoice.R
import com.example.geovoice.databinding.ActivityFirstPlaceBinding

class FirstPlaceActivity : AppCompatActivity() {
    lateinit var binding: ActivityFirstPlaceBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityFirstPlaceBinding.inflate(layoutInflater)
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
        binding.ib.setOnClickListener {
            // TODO: после того как добавишь аудиогид, реализовать медиаплеер
            // mediaPlayer = MediaPlayer.create(this, R.raw.)
            //mediaPlayer?.start()
        }
    }
}