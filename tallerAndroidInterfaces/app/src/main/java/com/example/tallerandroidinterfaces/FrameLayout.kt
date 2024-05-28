package com.example.tallerandroidinterfaces

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class FrameLayout : AppCompatActivity() {
    var btnPerro:Button?=null
    var btnGato:Button?=null
    var btnLoro:Button?=null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_frame_layout)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        btnPerro=findViewById(R.id.btnPerro)
        btnGato=findViewById(R.id.btnGato)
        btnLoro=findViewById(R.id.btnLoro)

        var btnVolver = findViewById<Button>(R.id.btnVolver)
        btnVolver.setOnClickListener {
            finish()
        }
    }
    fun verGato(view: View){
        btnPerro?.visibility=View.GONE
        btnGato?.visibility=View.VISIBLE
        btnLoro?.visibility=View.GONE
    }
    fun verLoro(view: View){
        btnPerro?.visibility=View.GONE
        btnGato?.visibility=View.GONE
        btnLoro?.visibility=View.VISIBLE
    }
    fun verPerro(view: View){
        btnPerro?.visibility=View.VISIBLE
        btnGato?.visibility=View.GONE
        btnLoro?.visibility=View.GONE
    }
}