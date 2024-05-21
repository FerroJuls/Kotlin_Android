package com.example.cambiofragment

import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.fragment.app.Fragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        var btnbutton1= findViewById<Button>(R.id.btnbutton1)
        var btnbutton2= findViewById<Button>(R.id.btnbutton2)
        var btnbutton3= findViewById<Button>(R.id.btnbutton3)
        btnbutton1.setOnClickListener {
            cambioFragment(position = 1)
        }
        btnbutton2.setOnClickListener {
            cambioFragment(position = 2)
        }
        btnbutton3.setOnClickListener {
            cambioFragment(position = 3)
        }
    }
    fun cambioFragment(position: Int){
        var fragment:Fragment
        when(position){
            1 ->fragment=FirstFragment()
            2 ->fragment=SecondFragment()
            3 ->fragment=ThirdFragment()
            else ->fragment=FirstFragment()
        }
        val fragmentManager=supportFragmentManager
        val fragmentTransition=fragmentManager.beginTransaction()

        fragmentTransition.replace(R.id.FCV,fragment)
        fragmentTransition.commit()
    }
}