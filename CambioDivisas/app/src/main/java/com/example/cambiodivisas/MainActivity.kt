package com.example.cambiodivisas

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.activity.ComponentActivity


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val editTextInput: EditText = findViewById(R.id.editTextInput)
        val buttonConvert: Button = findViewById(R.id.buttonConvert)
        val textViewResult: TextView = findViewById(R.id.textViewResult)
        val spinnerConversion = findViewById<Spinner>(R.id.spinnerConversion)

        val conversionRateSoles:Float = 3.75f
        val conversionRateDolares:Float = 0.27f
        var result:Float = 0f

        buttonConvert.setOnClickListener {
            val inputText = editTextInput.text.toString()

            if (inputText.isNotEmpty()) {

                val money = inputText.toFloat()
                val option = spinnerConversion.selectedItem.toString()

                when(option){
                    "Soles a Dolares" -> {
                        result = money * conversionRateDolares
                    }
                    "Dolares a Soles" -> {
                        result = money * conversionRateSoles
                    }
                }

                textViewResult.text = "Resultado: %.2f".format(result)
            } else {
                Toast.makeText(this, "Por favor, ingrese una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }
    }
}