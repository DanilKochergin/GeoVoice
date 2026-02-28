package com.example.geovoice.places.en

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.R
import com.example.geovoice.databinding.ActivitySecondPlaceEnBinding
import com.example.geovoice.places.ru.MainActivityRu

class SecondPlaceEn : AppCompatActivity() {
    lateinit var binding: ActivitySecondPlaceEnBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        binding = ActivitySecondPlaceEnBinding.inflate(layoutInflater)
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainActivityEn::class.java)
            startActivity(intent)
        }
        binding.ib.setOnClickListener {
            // TODO: после того как добавишь аудиогид, реализовать медиаплеер
            mediaPlayer = MediaPlayer.create(this, R.raw.salavulaevsounden)
            mediaPlayer?.start()
            if (mediaPlayer?.isPlaying == true){
                return@setOnClickListener
            }
        }
    }
}