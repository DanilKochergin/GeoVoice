package com.example.geovoice.places.ru

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.places.ru.MainActivityRu
import com.example.geovoice.R
import com.example.geovoice.databinding.ActivitySecondPlaceRuBinding

class SecondPlaceActivityRu : AppCompatActivity() {
    lateinit var binding: ActivitySecondPlaceRuBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySecondPlaceRuBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        binding.backbtn.setOnClickListener {
            val intent = Intent(this, MainActivityRu::class.java)
            startActivity(intent)
        }
        binding.ib.setOnClickListener {
            // TODO: после того как добавишь аудиогид, реализовать медиаплеер
            // mediaPlayer = MediaPlayer.create(this, R.raw.)
            //mediaPlayer?.start()
            //if (mediaPlayer?.isPlaying == true){
            //                return@setOnClickListener
            //            }
        }
    }
}