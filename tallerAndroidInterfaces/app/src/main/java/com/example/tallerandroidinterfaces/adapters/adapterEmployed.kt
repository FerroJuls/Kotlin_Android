package com.example.tallerandroidinterfaces.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerandroidinterfaces.R
import com.example.tallerandroidinterfaces.models.empleado
import java.text.FieldPosition

class adapterEmployed
    (var listEmployed: List<empleado>,
            var context:Context
            ): RecyclerView.Adapter<adapterEmployed.MyHolder>()
{
                inner class MyHolder(itemView: View): RecyclerView.ViewHolder(itemView){
                    lateinit var lblName: TextView
                    lateinit var lblPosition: TextView

                    init {
                        lblName=itemView.findViewById(R.id.lblName)
                        lblPosition=itemView.findViewById(R.id.lblPosition)

                    }
                }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterEmployed.MyHolder {
        var itemView=LayoutInflater.from(context).inflate(R.layout.item_employed,parent,false)
        return MyHolder(itemView)
    }

    override fun onBindViewHolder(holder: adapterEmployed.MyHolder, position: Int) {
        val empleado=listEmployed[position]
        holder.lblName.text=empleado.name
        holder.lblPosition.text=empleado.position
    }

    override fun getItemCount(): Int {
        return listEmployed.size
    }

}