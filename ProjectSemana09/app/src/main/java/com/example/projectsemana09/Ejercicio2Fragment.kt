package com.example.projectsemana09

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projectsemana09.databinding.FragmentEjercicio2Binding

class Ejercicio2Fragment : Fragment() {


    private lateinit var binding: FragmentEjercicio2Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        binding = FragmentEjercicio2Binding.inflate(inflater, container, false)
        val view = binding.root

        binding.btnCalcular2.setOnClickListener{
            var edadAna = binding.etNumber2.text.toString().toInt()
            var edadJuan = edadJuan(edadAna)
            if (edadJuan>0){
                binding.tvResult.text = "Resultado: La edad de Juan es $edadJuan"
            }else{
                binding.tvResult.text = "Resultado: Ana debe ser mayor a 5 años"
            }

        }

        return view
    }

    fun edadJuan(edad: Int): Int
    {
        return edad-5
    }

}