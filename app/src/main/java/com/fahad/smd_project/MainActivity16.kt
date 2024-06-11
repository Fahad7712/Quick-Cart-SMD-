package com.fahad.smd_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class MainActivity16 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main16)

        val saveButton = findViewById<Button>(R.id.saveButton)

        saveButton.setOnClickListener {
            val intent = Intent(this, MainActivity17::class.java)
            startActivity(intent)
        }
    }
}