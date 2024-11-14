package com.example.projectsemana09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsemana09.databinding.FragmentEjercicio5Binding

class Ejercicio5Fragment : Fragment() {

    private lateinit var binding: FragmentEjercicio5Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEjercicio5Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCalcular5.setOnClickListener {
            val number = binding.etNumber5.text.toString().toIntOrNull()
            if(number != null && number >0){
                val (escompuesto, factores) = esCompuestoYFactores(number)
                if(escompuesto){
                    binding.tvResult.text = "Resultado: El número $number es compuesto"
                    binding.tvFactores.text = "Factores: ${factores.joinToString(" - ")}"
                }else{
                    binding.tvResult.text = "Resultado: El número $number no es compuesto"
                    binding.tvFactores.text = ""
                }
            }else{
                binding.tvResult.text = "Por favor ingresa un número válido"
                binding.tvFactores.text = ""
            }
        }

        return view
    }

    fun esCompuestoYFactores(numero: Int): Pair<Boolean, List<Int>> {
        val factores = mutableListOf<Int>()

        for (i in 1..numero) {
            if (numero % i == 0) {
                factores.add(i)
            }
        }
        val esCompuesto = factores.size > 2

        return Pair(esCompuesto, factores)
    }


}