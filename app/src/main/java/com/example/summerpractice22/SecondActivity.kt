package com.example.summerpractice22

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.bumptech.glide.RequestManager
import com.example.summerpractice22.PlanetRepository.planet


class SecondActivity() : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        var id = intent.getIntExtra("id", 0)
        var planet = PlanetRepository.planet.get(id)
        val text = findViewById<TextView>(R.id.textView2)
        val picture = findViewById<ImageView>(R.id.imageView)

        text.setText("Name: ${planet.name}" +
                "\n Position: ${planet.position}" +
                "\n Weight: ${planet.weight} *10^23" +
                "\n Number of sputnik: ${planet.number_of_sputnik}" +
                "\n System: ${planet.system}")

        Glide.with(this)
                .load(PlanetRepository.planet.get(id).picture)
                .placeholder(R.drawable.test_planet)
                .error(R.drawable.test_planet)
                .into(picture)

        //private val glide: RequestManager
    }
}