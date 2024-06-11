package com.fahad.smd_project


data class Item(
    val description: String,
    val price: String,
    val imageUrl: String,  // Attribute to hold the image URL
    var quantity:Int
)