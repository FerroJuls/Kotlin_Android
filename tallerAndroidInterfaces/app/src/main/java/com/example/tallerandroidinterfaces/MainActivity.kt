package com.example.tallerandroidinterfaces

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

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
    }
    fun irLinearLayout(view: View){
        var intent= Intent(application,LinearLayout::class.java)
        startActivity(intent)
    }
    fun irRelativeLayout(view: View){
        var intent= Intent(application,RelativeLayout::class.java)
        startActivity(intent)
    }
    fun irFrameLayout(view: View){
        var intent= Intent(application,FrameLayout::class.java)
        startActivity(intent)
    }
    fun irConstraintLayout(view: View){
        var intent= Intent(application,ConstraintLayout::class.java)
        startActivity(intent)
    }
    fun irCardView(view: View){
        var intent= Intent(application,CardView::class.java)
        startActivity(intent)
    }
    fun irRecyclerView(view: View){
        var intent= Intent(application,RecyclerView::class.java)
        startActivity(intent)
    }
    fun irListView(view: View){
        var intent= Intent(application,ListView::class.java)
        startActivity(intent)
    }
    fun irInterfaz1(view: View){
        var intent= Intent(application,Interfaz1::class.java)
        startActivity(intent)
    }
    fun irInterfaz2(view: View){
        var intent= Intent(application,Interfaz2::class.java)
        startActivity(intent)
    }
    fun irInterfaz3(view: View){
        var intent= Intent(application,Interfaz3::class.java)
        startActivity(intent)
    }
    fun irInterfaz4(view: View){
        var intent= Intent(application,Interfaz4::class.java)
        startActivity(intent)
    }
}