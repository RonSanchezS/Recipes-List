package com.example.adapters

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Models.Ingredient
import com.example.listadeingredientes.R

class adapterRecipes(val data: ArrayList<Ingredient>, val listener: onContactClickListener) :
    RecyclerView.Adapter<adapterRecipes.recipesViewHolder>() {

    interface onContactClickListener {
        fun onContactClick(ingredient: Ingredient)
    }

    class recipesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreIngrediente : TextView
        val imagenIngrediente : ImageView
        init {
            nombreIngrediente = itemView.findViewById(R.id.txtNombreIngrediente);
            imagenIngrediente  = itemView.findViewById(R.id.imgIngrediente);
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recipesViewHolder {
        val view = View.inflate(parent.context, R.layout.ingrediente, null)
        return recipesViewHolder(view)

    }

    override fun onBindViewHolder(holder: recipesViewHolder, position: Int) {
        val item = data[position]
        holder.nombreIngrediente.text = item.name
        holder.imagenIngrediente.setImageResource(item.image)
        holder.itemView.setOnClickListener {
            listener.onContactClick(item)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }
}
