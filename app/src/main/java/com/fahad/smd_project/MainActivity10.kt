package com.fahad.smd_project


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class MainActivity10 : AppCompatActivity() {

    private lateinit var reviewEditText: EditText
    private lateinit var submitButton: Button
    private lateinit var skipButton: Button
    private lateinit var star1: ImageView
    private lateinit var star2: ImageView
    private lateinit var star3: ImageView
    private lateinit var star4: ImageView
    private lateinit var star5: ImageView
    private lateinit var database: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main10)

        reviewEditText = findViewById(R.id.reviewEditTextt)
        submitButton = findViewById(R.id.SubmitButton)
        skipButton = findViewById(R.id.SkipButton)
        star1 = findViewById(R.id.star1)
        star2 = findViewById(R.id.star2)
        star3 = findViewById(R.id.star3)
        star4 = findViewById(R.id.star4)
        star5 = findViewById(R.id.star5)
        database = FirebaseDatabase.getInstance().reference.child("reviews")

        submitButton.setOnClickListener {
            val reviewText = reviewEditText.text.toString().trim()
            if (reviewText.isNotEmpty()) {
                // Store review in Firebase
                storeReview(reviewText)
                // Show toast
                Toast.makeText(this, "Review submitted successfully!", Toast.LENGTH_SHORT).show()
            } else {
                // Show error toast if review is empty
                Toast.makeText(this, "Please write a review first", Toast.LENGTH_SHORT).show()
            }
        }

        star1.setOnClickListener { addRating(1) }
        star2.setOnClickListener { addRating(2) }
        star3.setOnClickListener { addRating(3) }
        star4.setOnClickListener { addRating(4) }
        star5.setOnClickListener { addRating(5) }

        skipButton.setOnClickListener {
            val intent = Intent(this, MainActivity11::class.java)
            startActivity(intent)
        }
    }

    private fun storeReview(review: String) {
        val reviewId = database.push().key
        reviewId?.let {
            val reviewData = HashMap<String, Any>()
            reviewData["review"] = review
            database.child(it).setValue(reviewData)
        }
    }

    private fun addRating(rating: Int) {
        // Store rating in Firebase
        database.child("rating").setValue(rating)
        // Show toast
        Toast.makeText(this, "Rating submitted: $rating", Toast.LENGTH_SHORT).show()
    }
}