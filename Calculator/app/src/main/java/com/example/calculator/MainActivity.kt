package com.example.calculator

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var textViewResult: TextView
    private var cadenaInput: String = ""
    private var operador: String = ""
    private var primerNumero: Double = 0.0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        textViewResult = findViewById(R.id.textViewResult)

        val botonesNumericos = listOf(
            findViewById<Button>(R.id.button0),
            findViewById<Button>(R.id.button1),
            findViewById<Button>(R.id.button2),
            findViewById<Button>(R.id.button3),
            findViewById<Button>(R.id.button4),
            findViewById<Button>(R.id.button5),
            findViewById<Button>(R.id.button6),
            findViewById<Button>(R.id.button7),
            findViewById<Button>(R.id.button8),
            findViewById<Button>(R.id.button9)
        )

        botonesNumericos.forEach { button ->
            button.setOnClickListener {
                insertarACadena(button.text.toString())
            }
        }

        findViewById<Button>(R.id.buttonAdd).setOnClickListener { definirOperador("+") }
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener { definirOperador("-") }
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener { definirOperador("*") }
        findViewById<Button>(R.id.buttonDivide).setOnClickListener { definirOperador("/") }

        findViewById<Button>(R.id.buttonEquals).setOnClickListener { calcularResultado() }

        findViewById<Button>(R.id.buttonClear).setOnClickListener { limpiar() }
    }

    private fun insertarACadena(valor: String) {
        cadenaInput += valor
        textViewResult.text = cadenaInput
    }

    private fun definirOperador(op: String) {
        if (cadenaInput.isNotEmpty()) {
            primerNumero = cadenaInput.toDouble()
            operador = op
            cadenaInput = ""
        }
    }

    private fun calcularResultado() {
        if (cadenaInput.isNotEmpty()) {
            val segundoValor = cadenaInput.toDouble()
            var resultado = 0.0

            when (operador) {
                "+" -> resultado = primerNumero + segundoValor
                "-" -> resultado = primerNumero - segundoValor
                "*" -> resultado = primerNumero * segundoValor
                "/" -> {
                    if (segundoValor != 0.0) {
                        resultado = primerNumero / segundoValor
                    } else {
                        textViewResult.text = "Error"
                        return
                    }
                }
            }

            textViewResult.text = resultado.toString()
            cadenaInput = resultado.toString()
            operador = ""
        }
    }

    private fun limpiar() {
        cadenaInput = ""
        primerNumero = 0.0
        operador = ""
        textViewResult.text = "0"
    }
}