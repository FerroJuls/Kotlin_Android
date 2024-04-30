package com.example.myapplication

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    lateinit var tvResult: TextView
    var operand1 = ""
    var operand2 = ""
    var operator = ""
    var decimalClicked = false

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
                decimalClicked = false
            }
            "=" -> {
                operand2 = tvResult.text.toString()
                if (operand2.isNotEmpty()) {
                    val result = when (operator) {
                        "+" -> operand1.toDouble() + operand2.toDouble()
                        "-" -> operand1.toDouble() - operand2.toDouble()
                        "*" -> operand1.toDouble() * operand2.toDouble()
                        "/" -> operand1.toDouble() / operand2.toDouble()
                        else -> 0.0
                    }
                    tvResult.text = formatResult(result)
                }
                decimalClicked = false
            }
            "AC" -> {
                operand1 = ""
                operator = ""
                tvResult.text = ""
                decimalClicked = false
            }
            "." -> {
                if (!decimalClicked) {
                    tvResult.append(".")
                    decimalClicked = true
                }
            }
            else -> {
                if (tvResult.text.toString() == "0") {
                    tvResult.text = buttonText
                } else {
                    tvResult.append(buttonText)
                }
            }
        }
    }

    private fun formatResult(value: Double): String {
        val decimalFormat = DecimalFormat("#.#####")
        return decimalFormat.format(value)
    }
}
