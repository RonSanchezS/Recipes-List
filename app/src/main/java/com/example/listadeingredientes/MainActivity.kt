package com.example.listadeingredientes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.Models.Ingredient
import com.example.Models.Recipe
import com.example.adapters.adapterRecipes

class MainActivity : AppCompatActivity(), adapterRecipes.onContactClickListener {
    private lateinit var listaIngredientes: RecyclerView
    var ingredientesPresionados = setOf<Ingredient>();
    private lateinit var lblRecetas: TextView
    var recetas = arrayListOf<Recipe>()
    private lateinit var btnBuscar: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        listaIngredientes = findViewById(R.id.recyclerView)
        lblRecetas = findViewById(R.id.lblRecetas)
        setUpListView()
        setUpListeners()
    }

    private fun setUpListeners() {
        //Busca las recetas que contengan parte de los ingredientes presionados


        btnBuscar.setOnClickListener {
            var recetasEncontradas = arrayListOf<Recipe>()
            for (receta in recetas) {
                if (receta.ingredients.containsAll(ingredientesPresionados)) {
                    recetasEncontradas.add(receta)
                }
            }
//            var recetasEncontradasString = ""
//            for (receta in recetasEncontradas) {
//                recetasEncontradasString += receta.name + "\n"
//            }
//            lblRecetas.text = recetasEncontradasString
            val intent = Intent(this, RecetasRecomendadas::class.java)

            //add recetasEncontradas to the extras
            intent.putExtra("recetasEncontradas", recetasEncontradas)
            startActivity(intent)
            //lblRecetas.text = "Recetas encontradas: " + recetasEncontradas.size
        }
//        val texto : StringBuilder = StringBuilder("Recetas: ")
//
//        for (receta in recetas) {
//            for (ingrediente in receta.ingredients) {
//                if (ingredientesPresionados.contains(ingrediente)) {
//                    texto.append(receta.name)
//                }
//            }
//        }
//        lblRecetas.text = texto.toString()
    }

    private fun setUpListView() {
        btnBuscar = findViewById(R.id.btnBuscarReceta)
        lblRecetas.text = "Tus ingredientes irán aqui:"
        val arroz = Ingredient("Arroz", 1, R.drawable.arroz)
        val pollo = Ingredient("Pollo", 1, R.drawable.pollo)
        val lechuga = Ingredient("Lechuga", 1, R.drawable.lechuga)
        val carneDeRes = Ingredient("Carne de res", 1, R.drawable.carnederes)
        val carneDeCerdo = Ingredient("Carne de cerdo", 1, R.drawable.carnedecerdo)
        val tomate = Ingredient("Tomate", 1, R.drawable.tomate)
        val cebolla = Ingredient("Cebolla", 1, R.drawable.cebolla)
        val calabaza = Ingredient("Calabaza", 1, R.drawable.calabaza)
        val pan = Ingredient("Pan", 1, R.drawable.pan)
        val limpiar = Ingredient("Limpiar lista", 2, R.drawable.rehacer)
        val ingredientes = arrayListOf<Ingredient>(
            arroz, carneDeRes, carneDeCerdo, pollo, lechuga, tomate, cebolla, calabaza, pan, limpiar
        )
        recetas = arrayListOf<Recipe>(
            Recipe("Arroz con pollo", arrayListOf(arroz, pollo), R.drawable.polloarroz, "1. Cocinar el arroz\n2. Cocinar el pollo\n3. Mezclar"),
            Recipe("Carne asada", arrayListOf(arroz, carneDeRes, cebolla, tomate),R.drawable.carneasada, "1. Cocinar el arroz\n2. Cocinar la carne\n3. Mezclar"),
            Recipe("Cerdo agridulce", arrayListOf(carneDeCerdo, cebolla, tomate, calabaza), R.drawable.cerdoagridulce, "1. Cocinar el cerdo\n2. Cocinar la cebolla\n3. Mezclar"),
            Recipe("Pollo encebollado", arrayListOf(cebolla, pollo) , R.drawable.pollocebolla, "1. Cocinar el pollo\n2. Cocinar la cebolla\n3. Mezclar"),
            Recipe("Sopa de lechuga", arrayListOf(lechuga, pan), R.drawable.sopadelechuga, "1. Cocinar la lechuga\n2. Mezclar con el pan\n3. Servir"),
            Recipe("Ensalada Cesar", arrayListOf(lechuga, tomate, pan), R.drawable.cesar, "1. Cocinar la lechuga\n2. Mezclar con el tomate\n3. Servir"),
            )


        val adapter = adapterRecipes(ingredientes, this)
        listaIngredientes.layoutManager = GridLayoutManager(this, 2)
        listaIngredientes.adapter = adapter


    }


    override fun onContactClick(ingredient: Ingredient) {
        if (ingredient.id==2){
            ingredientesPresionados = setOf<Ingredient>(
            )
            lblRecetas.text = "Tu lista se esta vacia, mira las recetas que tenemos para ti"
            return
        }
        if (ingredientesPresionados.contains(ingredient)) {
            ingredientesPresionados = ingredientesPresionados.minus(ingredient)
        } else {
            ingredientesPresionados = ingredientesPresionados.plus(ingredient)
        }
        if (ingredientesPresionados.isEmpty()) {
            lblRecetas.text = "Tu lista esta vacia, mira las recetas que tenemos para ti"
        } else {
            lblRecetas.text = "Tus ingredientes seleccionados: ${
                ingredientesPresionados.joinToString(
                    separator = ", "
                ) { it.name }
            }"
        }
        // lblRecetas.text = "Tus ingredientes seleccionados: ${ingredientesPresionados}"
    }

}