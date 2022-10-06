package com.example.Models

import java.io.Serializable

class Ingredient(
    val name:String,
    val id: Int,
    val image : Int
) : Serializable {
    override fun toString(): String {
        return name
    }
}