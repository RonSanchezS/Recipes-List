package com.example.listadeingredientes

import adapterVPRecetas
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.example.Models.Ingredient
import com.example.Models.Recipe
import com.example.listadeingredientes.R
import java.lang.StringBuilder

class RecetasRecomendadas : AppCompatActivity() {
    lateinit var recyclerRecetas : ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recetas_recomendadas)
        recyclerRecetas = findViewById(R.id.viewPagerRecetas)


        val recetasEncontradas = intent.getSerializableExtra("recetasEncontradas") as ArrayList<Recipe>




        val adapter = adapterVPRecetas(recetasEncontradas)
       // recyclerRecetas.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        recyclerRecetas.adapter = adapter


//        for (extra in intent.extras!!.keySet()) {
//            recetasMatch.add(intent.extras!!.get(extra) as Recipe)
//            texto.append(intent.extras!!.getString(extra).toString())
//        }


//        textox.text = texto.toString()
//        check if textox is empty
//        if (textox.text.isEmpty()) {
//            textox.text = "No hay recetas que combinen con dichos ingredientes"
//        }

    }


}