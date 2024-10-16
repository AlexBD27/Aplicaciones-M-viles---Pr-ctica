package com.example.project5atm

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.project5atm.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    // Declaramos la variable binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializamos el binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Cambio de divisas

        // Configura el adaptador del Spinner con un layout personalizado
        val adapter = ArrayAdapter.createFromResource(
            this,
            R.array.conversionOptions, R.layout.spinner_item
        )
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spinnerConversion.adapter = adapter

        binding.spinnerConversion.setSelection(0)


        val textViewResult = binding.textViewResult.text.toString().trim()
        val conversionRateSoles = 3.75f
        val conversionRateDolares = 0.27f
        var result = 0f

        binding.buttonConvert.setOnClickListener {
            val inputText = binding.editTextInput.text.toString().trim()

            if (inputText.isNotEmpty()) {

                val money = inputText.toFloat()
                val option = binding.spinnerConversion.selectedItem.toString()

                when(option){
                    "Soles a Dolares" -> {
                        result = money * conversionRateDolares
                    }
                    "Dolares a Soles" -> {
                        result = money * conversionRateSoles
                    }
                }
                binding.textViewResult.text = "Resultado: %.2f".format(result)
            } else {
                Toast.makeText(this, "Por favor, ingrese una cantidad válida", Toast.LENGTH_SHORT).show()
            }
        }



        //Configuramos el boton para cerrar sesion
        binding.btnLogout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

}