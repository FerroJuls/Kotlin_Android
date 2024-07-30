package com.example.movillibreria.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.movillibreria.R
import com.example.movillibreria.models.libro

class adapterLibro
    (var listLibro: List<libro>,
     var context: Context
): RecyclerView.Adapter<adapterLibro.MyHolder>()
{
    inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val lblTitulo: TextView = itemView.findViewById(R.id.lblTitulo)
        val lblAutor: TextView = itemView.findViewById(R.id.lblAutor)
        val lblIsbn: TextView = itemView.findViewById(R.id.lblIsbn)
        val lblGenero: TextView = itemView.findViewById(R.id.lblGenero)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterLibro.MyHolder {
        var itemView= LayoutInflater.from(context).inflate(R.layout.item_libro,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyHolder, position: Int) {
        val libro=listLibro[position]
        holder.lblTitulo.text=libro.titulo
        holder.lblAutor.text=libro.autor
        holder.lblIsbn.text=libro.isbn
        holder.lblGenero.text=libro.genero
    }

    override fun getItemCount(): Int {
        return listLibro.size
    }
}