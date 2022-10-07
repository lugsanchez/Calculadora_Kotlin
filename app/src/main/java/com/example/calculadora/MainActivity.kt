package com.example.calculadora

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    lateinit var campo1: EditText
    lateinit var campo2: EditText
    lateinit var resultado: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        /*mapeo de campos*/
        campo1 = this.findViewById(R.id.numero1)
        campo2 = this.findViewById(R.id.numero2)
        resultado = this.findViewById(R.id.resultado)
    }

    fun sumar(view: View) {
        val numero1: String = campo1.text.toString()
        val numero2: String = campo2.text.toString()
        val resultadofin = (numero1.toFloat() + numero2.toFloat())
        resultado.setText(resultadofin.toString())
    }

    fun restar(view: View) {
        val numero1: String = campo1.text.toString()
        var numero2: String = campo2.text.toString()
        val resultadofin = (numero1.toFloat() - numero2.toFloat())
        resultado.setText(resultadofin.toString())
    }

    fun multiplicar(view: View) {
        var numero1: String = campo1.text.toString()
        var numero2: String = campo2.text.toString()
        val resultadofin = (numero1.toFloat() * numero2.toFloat())
        resultado.setText(resultadofin.toString())
    }

    fun dividir(view: View) {
        var numero1: String = campo1.text.toString()
        var numero2: String = campo2.text.toString()
        val resultadofin = (numero1.toFloat() / numero2.toFloat())
        resultado.setText(resultadofin.toString())

    }

    fun clear(view: View){
        campo1.text.clear()
        campo2.text.clear()
        resultado.text= ""
    }

    fun btnCerrar(view: View){
        var preferences: SharedPreferences =getSharedPreferences("credenciales", Context.MODE_PRIVATE)
        var editor:SharedPreferences.Editor=preferences.edit()
        editor.putString("user","No existe la información")
        editor.putString("pass","No existe la información")

        editor.commit()
        Toast.makeText(this,"cerro sesion correctamente", Toast.LENGTH_SHORT).show()

            val intent = Intent (this, datosalmacenados::class.java)
            val miBundle:Bundle = Bundle()
            intent.putExtras(miBundle)
            startActivity(intent)

    }

    fun btnVentana(view: View){
            val intent = Intent (this, Historial::class.java)
            val miBundle:Bundle = Bundle()
            intent.putExtras(miBundle)
            startActivity(intent)
    }
}
