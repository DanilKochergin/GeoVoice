package com.example.geovoice.places.en

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.R
import com.example.geovoice.databinding.ActivityThirdPlaceEnBinding
import com.example.geovoice.places.ru.MainActivityRu

class ThirdPlaceEn : AppCompatActivity() {
    lateinit var binding: ActivityThirdPlaceEnBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityThirdPlaceEnBinding.inflate(layoutInflater)
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
        binding.ibRu.setOnClickListener {
            // TODO: после того как добавишь аудиогид, реализовать медиаплеер
            if (mediaPlayer?.isPlaying == true){
                return@setOnClickListener
            }
            mediaPlayer = MediaPlayer.create(this, R.raw.fatherlandmemorialsounden)
            mediaPlayer?.start()
        }
    }
}