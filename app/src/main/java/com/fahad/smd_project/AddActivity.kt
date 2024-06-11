package com.fahad.smd_project

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.storage.FirebaseStorage
import com.google.firebase.storage.StorageReference

class AddActivity : AppCompatActivity() {

    private lateinit var storage: FirebaseStorage
    private lateinit var storageRef: StorageReference
    private lateinit var database: DatabaseReference
    private var selectedImageUri: Uri? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.add_page)

        storage = FirebaseStorage.getInstance()
        storageRef = storage.reference.child("item_images")
        database = FirebaseDatabase.getInstance().reference.child("items")



        val Submitbutton: Button = findViewById(R.id.buttonAdd)
        Submitbutton.setOnClickListener {
            val nameInput = findViewById<EditText>(R.id.editTextName).text.toString()
            val piceInput = findViewById<EditText>(R.id.editTextDescription).text.toString()
            val categoryInput = findViewById<EditText>(R.id.editTextCategory).text.toString()

            if (selectedImageUri != null) {
                uploadImageAndItem(categoryInput, nameInput, piceInput)
            } else {
                Toast.makeText(this, "Please select an image", Toast.LENGTH_SHORT).show()
            }
        }



        val CameraButton: ImageButton = findViewById(R.id.buttonUploadPhoto)
        CameraButton.setOnClickListener {
            val intent = Intent(Intent.ACTION_PICK)
            intent.type = "image/*"
            resultLauncher.launch(intent)
        }
    }

    private val resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
        if (result.resultCode == Activity.RESULT_OK) {
            val data: Intent? = result.data
            selectedImageUri = data?.data
        }
    }

    private fun uploadItem(category: String, item: AddItem) {
        val newItemRef = database.child(category).push()
        val itemId = newItemRef.key

        if (itemId != null) {
            newItemRef.setValue(item)
                .addOnSuccessListener {
                    Toast.makeText(this, "Item added successfully", Toast.LENGTH_SHORT).show()
                    finish()
                }
                .addOnFailureListener { e ->
                    Toast.makeText(this, "Failed to add item: ${e.message}", Toast.LENGTH_SHORT).show()
                }
        } else {
            Toast.makeText(this, "Failed to generate item ID", Toast.LENGTH_SHORT).show()
        }
    }

    private fun uploadImageAndItem(category: String, name: String, price: String) {
        selectedImageUri?.let { imageUri ->
            val imageRef = storageRef.child("${System.currentTimeMillis()}.jpg")
            val uploadTask = imageRef.putFile(imageUri)

            uploadTask.continueWithTask { task ->
                if (!task.isSuccessful) {
                    task.exception?.let {
                        throw it
                    }
                }
                imageRef.downloadUrl
            }.addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    val downloadUri = task.result
                    val imageUrl = downloadUri.toString()

                    val item = AddItem(name, price, imageUrl)
                    uploadItem(category, item)
                } else {
                    Toast.makeText(this, "Failed to upload image", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
