package com.example.projectsemana09

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projectsemana09.databinding.FragmentEjercicio1Binding
import kotlin.math.sqrt

class Ejercicio1Fragment : Fragment() {


    private lateinit var binding:FragmentEjercicio1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEjercicio1Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCalcular1.setOnClickListener{
            var number: Int? = binding.etNumber1.text.toString().toIntOrNull()
            if(number != null){
                if (esPrimo(number))
                {
                    binding.tvResult.text = "Resultado: $number es primo"
                }else{
                    binding.tvResult.text = "Resultado: $number no es primo"
                }
            } else {
                binding.tvResult.text = "Por favor ingresa un número válido"
            }
        }

        return view
    }

    fun esPrimo(numero: Int): Boolean {
        if (numero < 2) return false
        for (i in 2..sqrt(numero.toDouble()).toInt()) {
            if (numero % i == 0) {
                return false
            }
        }
        return true
    }

}