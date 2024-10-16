package com.example.project4

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import com.example.project4.databinding.ActivityMainBinding
import com.example.project4.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {

    // Declaramos la variable binding
    private lateinit var binding: ActivitySecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //Inicializamos el binding
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Se obtiene el valor de username
        val username = intent.getStringExtra("username")

        //Mostrar mensaje de bienvenida
        binding.tvWelcome.text = "Bienvenido $username"

        //Configuramos el boton para cerrar sesion
        binding.btnLogout.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}