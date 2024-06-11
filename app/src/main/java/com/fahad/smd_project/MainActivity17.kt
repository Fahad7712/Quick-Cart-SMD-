package com.fahad.smd_project

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class MainActivity17 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main17)


        val toolnavigationView = findViewById<ImageView>(R.id.toolnavigationView)

        toolnavigationView.setOnClickListener {
            val intent = Intent(this, MainActivity19::class.java)
            startActivity(intent)
        }

        val homenavigationView = findViewById<ImageView>(R.id.homenavigationView)

        homenavigationView.setOnClickListener {
            val intent = Intent(this, MainActivity18::class.java)
            startActivity(intent)
        }


        val Chatwithustext = findViewById<TextView>(R.id.Chatwithustext)

        Chatwithustext.setOnClickListener {
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }




        val EditProfiletext = findViewById<TextView>(R.id.EditProfiletext)

        EditProfiletext.setOnClickListener {
            val intent = Intent(this, MainActivity16::class.java)
            startActivity(intent)
        }


        val MyAddresstext = findViewById<TextView>(R.id.MyAddresstext)

        MyAddresstext.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }

        val MyOrderstext = findViewById<TextView>(R.id.MyOrderstext)

        MyOrderstext.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }


        val MyWishlisttext = findViewById<TextView>(R.id.MyWishlisttext)

        MyWishlisttext.setOnClickListener {
            val intent = Intent(this, MainActivity13::class.java)
            startActivity(intent)
        }

        val TalktoourSupporttext = findViewById<TextView>(R.id.TalktoourSupporttext)

        TalktoourSupporttext.setOnClickListener {
            val intent = Intent(this, MainActivity9::class.java)
            startActivity(intent)
        }

        val Logouttext = findViewById<TextView>(R.id.Logouttext)

        Logouttext.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }


        val AddWishlist = findViewById<TextView>(R.id.Messagetofacebookpagetext)

        AddWishlist.setOnClickListener {
            val intent = Intent(this, MainActivity15::class.java)
            startActivity(intent)
        }




        val submitfeedbacktext = findViewById<TextView>(R.id.submitfeedbacktext)

        submitfeedbacktext.setOnClickListener {
            val intent = Intent(this, MainActivity10::class.java)
            startActivity(intent)
        }

        val searchsomethingtext = findViewById<TextView>(R.id.searchsomethingtext)

        searchsomethingtext.setOnClickListener {
            val intent = Intent(this, MainActivity8::class.java)
            startActivity(intent)
        }

    }
}