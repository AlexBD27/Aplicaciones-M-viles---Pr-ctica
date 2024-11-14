package com.example.projectsemana09

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.projectsemana09.databinding.FragmentEjercicio4Binding

class Ejercicio4Fragment : Fragment() {

    private lateinit var binding: FragmentEjercicio4Binding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentEjercicio4Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCalcular4.setOnClickListener {
            var trabajadores = binding.etNumTrabajadores.text.toString().toIntOrNull()
            var dias = binding.etDiasIniciales.text.toString().toIntOrNull()

            if(trabajadores != null && dias != null && trabajadores > 0 && dias > 0){
                var diasNecesarios = calcularDiasTrabajando(trabajadores, dias)
                binding.tvResult.text = "Resultado: $diasNecesarios dias necesarios"
            }else{
                binding.tvResult.text = "Por favor ingrese datos válidos"
            }
        }


        return view
    }

    fun calcularDiasTrabajando(trabajadores: Int, diasIniciales: Int): Int {
        val trabajoTotal = 4 * diasIniciales
        val diasNecesarios = trabajoTotal / trabajadores
        return diasNecesarios
    }


}