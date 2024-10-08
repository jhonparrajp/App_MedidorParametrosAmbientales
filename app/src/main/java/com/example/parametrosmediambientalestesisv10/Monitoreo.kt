package com.example.parametrosmediambientalestesisv10

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Monitoreo : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()











        setContentView(R.layout.activity_monitoreo)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }






    }
    fun guardar(view: View){
        // Guardar los datos en la base de datos
        // ...
        
    }
    fun irGraficas(view: View){
        // Ir a la actividad de monitoreo
        val siguiente = Intent(this, Graficas::class.java)
        startActivity(siguiente)
    }
    fun irTablas(view: View){
        // Ir a la actividad de tablas
        val siguiente = Intent(this, Tablas::class.java)
        startActivity(siguiente)
    }
}