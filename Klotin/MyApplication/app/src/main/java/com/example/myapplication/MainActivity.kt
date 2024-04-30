package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var tvResult: TextView
    var operand1 = ""
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        tvResult = findViewById(R.id.tvResul)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    fun calcular(view: View) {
        val button = view as Button
        val buttonText = button.text.toString()

        when (buttonText) {
            "+", "-", "*", "/" -> {
                operand1 = tvResult.text.toString()
                operator = buttonText
                tvResult.text = "0"
            }
            "=" -> {
                val operand2 = tvResult.text.toString()
                val result = when (operator) {
                    "+" -> operand1.toDouble() + operand2.toDouble()
                    "-" -> operand1.toDouble() - operand2.toDouble()
                    "*" -> operand1.toDouble() * operand2.toDouble()
                    "/" -> operand1.toDouble() / operand2.toDouble()
                    else -> 0.0
                }
                tvResult.text = result.toString()
            }
            "AC" -> {
                operand1 = ""
                operator = ""
                tvResult.text = "0"
            }
            else -> {
                if (tvResult.text == "0" || operator.isNotEmpty()) {
                    tvResult.text = buttonText
                } else {
                    tvResult.append(buttonText)
                }
            }
        }
    }
}