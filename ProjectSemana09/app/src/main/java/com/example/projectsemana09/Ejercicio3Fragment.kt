package com.example.projectsemana09

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projectsemana09.databinding.FragmentEjercicio3Binding

class Ejercicio3Fragment : Fragment() {

    private lateinit var binding: FragmentEjercicio3Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEjercicio3Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCalcular3.setOnClickListener {
            val base = binding.etBase.text.toString().toFloatOrNull()
            val altura = binding.etAltura.text.toString().toFloatOrNull()

            if (base != null && altura != null && base > 0 && altura > 0) {
                val area = calcularArea(base, altura)
                binding.tvResult.text = "Resultado: El área es $area"
            } else {
                binding.tvResult.text = "Por favor ingresa valores válidos mayores a 0"
            }
        }

        return view
    }

    fun calcularArea(base: Float, altura:Float): Float
    {
        return base*altura/2
    }

}