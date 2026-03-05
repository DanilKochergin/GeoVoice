package com.example.geovoice.places.ru

import android.content.Intent
import android.media.MediaPlayer
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
    private var mediaPlayer: MediaPlayer? = null
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
            if (mediaPlayer == null){
                mediaPlayer = MediaPlayer.create(this, R.raw.salulru)
            }
            if (mediaPlayer?.isPlaying == true){
                mediaPlayer?.pause()
                binding.ib.setImageResource(R.drawable.playbtn)
            } else {
                mediaPlayer?.start()
                binding.ib.setImageResource(R.drawable.pausebtn)
            }
        }
    }
}