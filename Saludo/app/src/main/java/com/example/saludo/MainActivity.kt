package com.example.saludo

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.btnIngresar)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

    //DEFINICIÓN DE LOS OBJETOS
    var btnIngresar: Button
    var txtPrimerNombre: TextView

    //ASIGNACIÓN DEL VALOR
        btnIngresar=findViewById(R.id.btnIngresar)
        txtPrimerNombre=findViewById(R.id.txtPrimerNombre)
        //configurar la accion al precionar el boton ingresar
        btnIngresar.setOnClickListener {
            var primerNombre=txtPrimerNombre.text
            //se utiliza el mensaje toas para mostrar el saludo
            Toast.makeText(applicationContext,
                "Hola ${primerNombre}",
                Toast.LENGTH_LONG
            ).show()
        }
    }
}
