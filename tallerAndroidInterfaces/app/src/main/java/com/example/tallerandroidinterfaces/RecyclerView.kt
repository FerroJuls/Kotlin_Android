package com.example.tallerandroidinterfaces

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tallerandroidinterfaces.adapters.adapterEmployed
import com.example.tallerandroidinterfaces.models.empleado

class RecyclerView : AppCompatActivity() {

    lateinit var listEmpleado:MutableList<empleado>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_recycler_view)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        listEmpleado= mutableListOf()
        var empleado=empleado("Julian","Vocero")
        listEmpleado.add(empleado)
        listEmpleado.add(empleado("Carlos","Instructor"))
        listEmpleado.add(empleado("Laura","Aprendiz"))
        listEmpleado.add(empleado("Anyi","Aprendiz"))
        listEmpleado.add(empleado("Maidy","Aprendiz"))
        listEmpleado.add(empleado("Angie","Aprendiz"))
        listEmpleado.add(empleado("Camilo","Aprendiz"))
        listEmpleado.add(empleado("Aura","Aprendiz"))
        listEmpleado.add(empleado("Penna","Aprendiz"))
        listEmpleado.add(empleado("Kevin","Aprendiz"))

        var recycler=findViewById<RecyclerView>(R.id.RVEmployed)
        recycler.layoutManager=LinearLayoutManager(applicationContext)
        var adapterEmployed=adapterEmployed(listEmpleado,applicationContext)
        recycler.adapter=adapterEmployed

        var btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
}