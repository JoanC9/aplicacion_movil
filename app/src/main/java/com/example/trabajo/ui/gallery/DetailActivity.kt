package com.example.trabajo.ui.gallery


import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.ImageView
import com.example.trabajo.R

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val imageView = findViewById<ImageView>(R.id.fullImage)
        val imageRes = intent.getIntExtra("IMAGE_RES", 0)
        imageView.setImageResource(imageRes)

        imageView.setOnClickListener { finish() }
    }
}