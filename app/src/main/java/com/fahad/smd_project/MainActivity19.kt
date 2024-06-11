package com.fahad.smd_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView

class MainActivity19 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main19)


        val fruitsVegetables: ImageView = findViewById(R.id.FruitsVegetables)
        val breakfast: ImageView = findViewById(R.id.Breakfast)
        val beverages: ImageView = findViewById(R.id.Beverages)
        val meat: ImageView = findViewById(R.id.Meat)
        val snacks: ImageView = findViewById(R.id.Snacks)
        val dairy: ImageView = findViewById(R.id.Dairy)

        val linenavigationView = findViewById<ImageView>(R.id.linenavigationView)

        linenavigationView.setOnClickListener {
            val intent = Intent(this, MainActivity17::class.java)
            startActivity(intent)
        }


        val homenavigationView = findViewById<ImageView>(R.id.homenavigationView)

        homenavigationView.setOnClickListener {
            val intent = Intent(this, MainActivity18::class.java)
            startActivity(intent)
        }


        fruitsVegetables.setOnClickListener {
            sendCategoryNameAndNavigate("Fruits and Vegetables")
        }

        breakfast.setOnClickListener {
            sendCategoryNameAndNavigate("Breakfast")
        }

        beverages.setOnClickListener {
            sendCategoryNameAndNavigate("Beverages")
        }

        meat.setOnClickListener {
            sendCategoryNameAndNavigate("Meat")
        }

        snacks.setOnClickListener {
            sendCategoryNameAndNavigate("Snacks")
        }

        dairy.setOnClickListener {
            sendCategoryNameAndNavigate("Dairy")
        }




    }

    private fun sendCategoryNameAndNavigate(categoryName: String) {
        val intent = Intent(this, FifthActivity::class.java)
        intent.putExtra("categoryName", categoryName)
        startActivity(intent)
    }
}