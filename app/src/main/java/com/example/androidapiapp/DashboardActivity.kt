package com.example.androidapiapp

import android.content.Intent
import android.os.Bundle
import com.example.androidapiapp.ui.DashboardViewModel
import androidx.recyclerview.widget.RecyclerView
import com.example.androidapiapp.data.Entity
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.androidapiapp.recyclerview.EntityAdapter
import dagger.hilt.android.AndroidEntryPoint
@AndroidEntryPoint
class DashboardActivity : AppCompatActivity() {
    private val viewModel: DashboardViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.layoutManager = LinearLayoutManager(this)


       val keypass = intent.getStringExtra("KEYPASS")

        if (keypass == null) {
            startActivity(Intent(this, LoginActivity::class.java))
            finish()
            return
        }

        viewModel.entities.observe(this) { entities ->
            recyclerView.adapter = EntityAdapter(entities) { entity ->
                val intent = Intent(this,DetailsActivity::class.java)
                intent.putExtra("ENTITY", entity)
                startActivity(intent)
            }
        }

        viewModel.loadEntities(keypass)
    }
}