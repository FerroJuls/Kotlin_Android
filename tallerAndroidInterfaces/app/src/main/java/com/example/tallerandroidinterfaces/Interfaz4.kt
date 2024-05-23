package com.example.tallerandroidinterfaces

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Interfaz4 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_interfaz4)

        val ciudadesPorDepartamento = mapOf(
            "Amazonas" to listOf("Leticia", "Puerto Nariño"),
            "Antioquia" to listOf("Medellín", "Bello", "Itagüí", "Envigado", "Apartadó"),
            "Arauca" to listOf("Arauca", "Saravena"),
            "Atlántico" to listOf("Barranquilla", "Soledad", "Malambo"),
            "Bolívar" to listOf("Cartagena", "Magangué", "Turbo"),
            "Boyacá" to listOf("Tunja", "Duitama", "Sogamoso"),
            "Caldas" to listOf("Manizales", "La Dorada", "Chinchiná"),
            "Caquetá" to listOf("Florencia", "Belén de los Andaquíes"),
            "Casanare" to listOf("Yopal", "Villanueva", "Paz de Ariporo"),
            "Cauca" to listOf("Popayán", "Santander de Quilichao", "Piendamó"),
            "Cesar" to listOf("Valledupar", "Aguachica", "La Jagua de Ibirico"),
            "Chocó" to listOf("Quibdó", "Nuquí", "Istmina"),
            "Córdoba" to listOf("Montería", "Sincelejo", "Lorica"),
            "Cundinamarca" to listOf("Bogotá", "Soacha", "Zipaquirá", "Girardot"),
            "Guainía" to listOf("Inírida"),
            "Guaviare" to listOf("San José del Guaviare"),
            "Huila" to listOf("Neiva", "Pitalito", "Garzón"),
            "La Guajira" to listOf("Riohacha", "Maicao", "Uribia"),
            "Magdalena" to listOf("Santa Marta", "Ciénaga", "Fundación"),
            "Meta" to listOf("Villavicencio", "Acacías", "Granada"),
            "Nariño" to listOf("Pasto", "Tumaco", "Ipiales"),
            "Norte de Santander" to listOf("Cúcuta", "Ocaña", "Pamplona"),
            "Putumayo" to listOf("Mocoa", "Puerto Asís", "Villagarzón"),
            "Quindío" to listOf("Armenia", "Calarcá", "Quimbaya"),
            "Risaralda" to listOf("Pereira", "Dosquebradas", "La Virginia"),
            "San Andrés y Providencia" to listOf("San Andrés", "Providencia"),
            "Santander" to listOf("Bucaramanga", "Floridablanca", "Girón"),
            "Sucre" to listOf("Sincelejo", "Corozal", "San Onofre"),
            "Tolima" to listOf("Ibagué", "Espinal", "Mariquita"),
            "Valle del Cauca" to listOf("Cali", "Buenaventura", "Palmira"),
            "Vaupés" to listOf("Mitú"),
            "Vichada" to listOf("Puerto Carreño"),

        )


        val datos = ciudadesPorDepartamento.flatMap { entry ->
            val departamento = entry.key
            val ciudades = entry.value
            ciudades.map { ciudad -> "$departamento - $ciudad" }
        }

        val adaptador = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, datos)


        val listViewInterfaz = findViewById<ListView>(R.id.listViewInterfaz)

        listViewInterfaz.adapter = adaptador

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
}