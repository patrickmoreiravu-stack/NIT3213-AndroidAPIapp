package com.example.androidapiapp

import android.content.Intent
import android.os.Bundle
import com.example.androidapiapp.ui.LoginViewModel
import android.widget.EditText
import android.widget.Button
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val username = findViewById<EditText>(R.id.usernameInput)
        val password = findViewById<EditText>(R.id.passwordInput)
        val loginBtn = findViewById<Button>(R.id.loginBtn)

        loginBtn.setOnClickListener {
            viewModel.login("footscray", username.text.toString(), password.text.toString())
        }

        viewModel.loginResult.observe(this) { response ->
            if (response != null) {
                val intent = Intent(this, DashboardActivity::class.java)
                intent.putExtra("KEYPASS", response.keypass)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}