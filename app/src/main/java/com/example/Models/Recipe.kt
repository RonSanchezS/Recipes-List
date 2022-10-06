package com.example.Models

import java.io.Serializable

class Recipe(
    val name: String,
    var ingredients: ArrayList<Ingredient>,
    var imagen: Int,
    var description: String,
) : Serializable {
    override fun toString(): String {
        return name
    }
}