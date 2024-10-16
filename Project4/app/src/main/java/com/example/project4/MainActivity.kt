package com.example.project4

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.widget.Toast
import com.example.project4.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    // Declaramos la variable binding
    private lateinit var binding: ActivityMainBinding
    var username:String = "Alex"
    var password:String = "1234"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        //Inicializamos el binding
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //Configuramos el boton para iniciar sesion
        binding.btnLogin.setOnClickListener{
            val username = binding.etUsername.text.toString().trim()
            val password = binding.etPassword.text.toString().trim()

            if (username.isEmpty() || password.isEmpty()){
                Toast.makeText(this, "Por favor llena todos los campos", Toast.LENGTH_SHORT).show()
            }else{
                //Logica de autenticacion
                //Se asume cualquier user and password de ejemplo

                if(check(username, password)){
                    val intent = Intent(this, SecondActivity::class.java)
                    intent.putExtra("username", username)
                    startActivity(intent)
                }else{
                    Toast.makeText(this, "Datos de ingreso incorrectos", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    fun check(usuario:String, contraseña: String):Boolean {
        return usuario==username && contraseña==password
    }
}