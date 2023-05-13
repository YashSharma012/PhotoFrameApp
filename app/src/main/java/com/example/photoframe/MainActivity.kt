package com.example.photoframe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var currImage = 1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val prev = findViewById<ImageButton>(R.id.imgPrev)
        val next = findViewById<ImageButton>(R.id.imgNext)
        val text = findViewById<TextView>(R.id.nameText)
        val img = findViewById<ImageView>(R.id.imageView)

        prev.setOnClickListener {
            setImage(currImage, img, text)
            currImage = (5 + currImage - 1) % 5
        }

        next.setOnClickListener {
            setImage(currImage, img, text)
            currImage = (5 + currImage + 1) % 5
        }
    }

    private fun setImage(currImage : Int, img : ImageView, text : TextView){
        val drawableResource = when(currImage) {
            1 -> R.drawable.pic1
            2 -> R.drawable.pic2
            3 -> R.drawable.pic3
            4 -> R.drawable.pic4
            else -> {
                R.drawable.pic1
            }
        }
        val textResource = when(currImage) {
            1 -> text.setText("Field Marshal Sam Manekshaw")
            2 -> text.setText("Major Mohit Sharma")
            3 -> text.setText("Major Sandeep Unnikrishnan")
            4 -> text.setText("CDS Bipin Rawat")
            else -> text.setText("Field Marshal Sam Manekshaw")
        }
        img.setImageResource(drawableResource)
    }
}

