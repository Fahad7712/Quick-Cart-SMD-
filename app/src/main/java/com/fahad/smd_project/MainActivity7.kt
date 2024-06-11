package com.fahad.smd_project


import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity7 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main7)

        val selectedDate = intent.getStringExtra("selectedDate")
        val totalCharges = intent.getDoubleExtra("totalCharges", 0.0)

        val historyordertext = findViewById<TextView>(R.id.historyordertext)
        val dateTextView = findViewById<TextView>(R.id.dateTextView)
        val totalChargesTextView = findViewById<TextView>(R.id.totalTextView)

        dateTextView.text = "Selected Date: $selectedDate"
        totalChargesTextView.text = "Total Charges: $$totalCharges"

        historyordertext.setOnClickListener {
            historyordertext.setOnClickListener {
                val intent = Intent(this, MainActivity12::class.java)
                startActivity(intent)
            }
        }
    }
}