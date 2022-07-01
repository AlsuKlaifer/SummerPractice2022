package com.example.summerpractice22

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import kotlin.math.absoluteValue

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var textview = findViewById<TextView>(R.id.textview)
        var heigth = findViewById<EditText>(R.id.editTextHeight)
        var age = findViewById<EditText>(R.id.editTextAge)
        var weight = findViewById<EditText>(R.id.editTextWeigth)
        var button = findViewById<Button>(R.id.button)
        var name = findViewById<EditText>(R.id.editTextName)

        button.setOnClickListener {
            if(name.text.length > 0 && age.text.length > 0 && heigth.text.length > 0 && weight.text.length > 0){
                var n = name.text.length
                var a = age.text.toString().toInt()
                var w = weight.text.toString().toFloat()
                var h = heigth.text.toString().toInt()
                if (n > 50 || a < 0 || a > 150 || w < 0 || w > 250 || h < 0 || h > 250) {
                    textview.setText("Данные введены некорректно.")
                }

                else {
                    var value = Math.abs(Math.round(name.text.length + age.text.toString().toInt() *
                            weight.text.toString().toFloat() - heigth.text.toString().toInt()))
                    textview.setText("Ответ: $value")
                }
            }
            else
                textview.setText("Данные введены некорректно.")
        }
    }
}