import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.Models.Recipe
import com.example.listadeingredientes.R

class adapterVPRecetas(val data: ArrayList<Recipe>) :
    RecyclerView.Adapter<adapterVPRecetas.recipes2ViewHolder>() {

    class recipes2ViewHolder (itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombreReceta : TextView
        val descripcionReceta : TextView
        val imagenReceta : ImageView
        val ingredientesReceta : TextView
        init {
            nombreReceta = itemView.findViewById(R.id.lblTituloReceta)
            descripcionReceta = itemView.findViewById(R.id.lblDescripcionReceta)
            imagenReceta = itemView.findViewById(R.id.imgRecetaA)
            ingredientesReceta = itemView.findViewById(R.id.lblIngredientes)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): recipes2ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.receta, parent, false)
        return recipes2ViewHolder(view)
    }

    override fun onBindViewHolder(holder: recipes2ViewHolder, position: Int) {
        val receta = data[position]
        holder.nombreReceta.text = receta.name
        holder.descripcionReceta.text = receta.description
        holder.ingredientesReceta.text = receta.ingredients.toString()
        holder.imagenReceta.setImageResource(receta.imagen)
    }

    override fun getItemCount(): Int {
        return data.size
    }

}