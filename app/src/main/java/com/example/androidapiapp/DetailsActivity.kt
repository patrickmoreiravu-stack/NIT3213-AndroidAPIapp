package com.example.androidapiapp

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.androidapiapp.data.Entity

class DetailsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_details)

        val entity = intent.getParcelableExtra<Entity>("ENTITY")

        //Hook up views
        val titleText: TextView = findViewById(R.id.detailTitle)
        val authorText: TextView = findViewById(R.id.detailAuthor)
        val genreText: TextView = findViewById(R.id.detailGenre)
        val publicationYearText: TextView = findViewById(R.id.detailPublicationYear)
        val descriptionText: TextView = findViewById(R.id.detailDescription)

        entity?.let {
            titleText.text = it.title ?: "No title"
            authorText.text = "Author: ${it.author ?: "Unknown"}"
            genreText.text = "Genre: ${it.genre ?: "Unknown"}"
            publicationYearText.text = "Publication Year: ${it.publicationYear ?: "Unknown"}"
            descriptionText.text = it.description ?: "No description"
        }
    }
}