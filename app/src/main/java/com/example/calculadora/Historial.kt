package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class Historial : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historial)

        fun btnVolver(view: View){
            val intent = Intent (this, MainActivity::class.java)
            val miBundle:Bundle = Bundle()
            intent.putExtras(miBundle)
            startActivity(intent)
        }
    }
}