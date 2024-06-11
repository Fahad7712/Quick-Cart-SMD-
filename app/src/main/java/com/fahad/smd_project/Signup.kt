package com.fahad.smd_project

data class Signup(
    var name: String = "",
    var email: String = "",
    var country: String = "",
    var password: String = "",
    var city: String = "",
    var imageUrl: String = ""
) {
    // Default constructor
    constructor() : this("", "", "", "", "", "")
}