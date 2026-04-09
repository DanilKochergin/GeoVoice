package com.example.geovoice.places.ru

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.geovoice.R
import com.example.geovoice.databinding.ActivityThirdPlaceRuBinding

class ThirdPlaceActivityRu : AppCompatActivity() {
    lateinit var binding: ActivityThirdPlaceRuBinding
    private var mediaPlayer: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        binding = ActivityThirdPlaceRuBinding.inflate(layoutInflater)
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
                mediaPlayer = MediaPlayer.create(this, R.raw.fatherlandmemorialru)
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