package com.fahad.smd_project

data class AddItem(
    val name: String = "",
    val price: String = "", // Changed field name from description to pice
    val imageUrl: String = ""
    )
