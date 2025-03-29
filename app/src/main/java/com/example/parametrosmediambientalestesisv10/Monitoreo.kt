package com.example.parametrosmediambientalestesisv10

import android.app.ActivityOptions
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.ProgressBar
import android.widget.Switch
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Monitoreo : AppCompatActivity() {

    var pbConductividad: ProgressBar? = null
    var tvConductividad: TextView? = null

    var pbTds: ProgressBar? = null
    var tvTds: TextView? = null

    var pbTempAgua: ProgressBar? = null
    var tvTempAgua: TextView? = null

    var pbTempAire: ProgressBar? = null
    var tvTempAire: TextView? = null

    var pbHumedad: ProgressBar? = null
    var tvHumedad: TextView? = null

    var pbLuzVisible: ProgressBar? = null
    var tvLuzVisible: TextView? = null

    var pbLuzIr: ProgressBar? = null
    var tvLuzIr: TextView? = null

    var pbIndiceUv: ProgressBar? = null
    var tvIndiceUv: TextView? = null

    var switchMediciones:Switch?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_monitoreo)

        pbConductividad = findViewById(R.id.pbConductividad)
        tvConductividad = findViewById(R.id.tvConductividad)

        pbTds = findViewById(R.id.pbTds)
        tvTds = findViewById(R.id.tvTds)

        pbTempAgua = findViewById(R.id.pbTempAgua)
        tvTempAgua = findViewById(R.id.tvTempAgua)

        pbTempAire = findViewById(R.id.pbTempAire)
        tvTempAire = findViewById(R.id.tvTempAire)

        pbHumedad = findViewById(R.id.pbHumedad)
        tvHumedad = findViewById(R.id.tvHumedad)

        pbLuzVisible = findViewById(R.id.pbLuzVisible)
        tvLuzVisible = findViewById(R.id.tvLuzVisible)

        pbLuzIr = findViewById(R.id.pbir)
        tvLuzIr = findViewById(R.id.tvLuzIr)

        pbIndiceUv = findViewById(R.id.pbIndice)
        tvIndiceUv = findViewById(R.id.tvIndiceUv)

        switchMediciones = findViewById(R.id.swMediciones)



       // restaurarValores()

        // Manejo del Switch
        switchMediciones?.setOnCheckedChangeListener { _, isChecked ->
            if (isChecked) {
                // Código para cuando el Switch está activado
                Toast.makeText(this, "Iniciando Mediciones...", Toast.LENGTH_LONG).show()
                  // Cambiar el estado de la barra de progreso, por ejemplo
            } else {
                // Código para cuando el Switch está desactivado
                Toast.makeText(this, "Finalizando Mediciones...", Toast.LENGTH_LONG).show()
                pbConductividad?.progress = 0
                pbTds?.progress = 0
                pbTempAire?.progress = 0
                pbTempAgua?.progress = 0
                pbHumedad?.progress = 0
                pbLuzVisible?.progress = 0
                pbLuzIr?.progress = 0
                pbIndiceUv?.progress = 0


            }
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }


    }
    // Guardar los valores cuando la actividad se pausa
    override fun onPause() {
        super.onPause()
        guardarValores()
    }

    // Restaurar los valores cuando la actividad se retome
    override fun onResume() {
        super.onResume()
        restaurarValores()
    }

    // Guardar los valores en SharedPreferences
    private fun guardarValores() {
        val sharedPreferences = getSharedPreferences("MonitoreoPrefs", MODE_PRIVATE)
        val editor = sharedPreferences.edit()

        editor.putInt("pbConductividad", pbConductividad?.progress ?: 0)
        editor.putString("tvConductividad", tvConductividad?.text.toString())

        editor.putInt("pbTds", pbTds?.progress ?: 0)
        editor.putString("tvTds", tvTds?.text.toString())

        editor.putInt("pbTempAgua", pbTempAgua?.progress ?: 0)
        editor.putString("tvTempAgua", tvTempAgua?.text.toString())

        editor.putInt("pbTempAire", pbTempAire?.progress ?: 0)
        editor.putString("tvTempAire", tvTempAire?.text.toString())

        editor.putInt("pbHumedad", pbHumedad?.progress ?: 0)
        editor.putString("tvHumedad", tvHumedad?.text.toString())

        editor.putInt("pbLuzVisible", pbLuzVisible?.progress ?: 0)
        editor.putString("tvLuzVisible", tvLuzVisible?.text.toString())

        editor.putInt("pbLuzIr", pbLuzIr?.progress ?: 0)
        editor.putString("tvLuzIr", tvLuzIr?.text.toString())

        editor.putInt("pbIndiceUv", pbIndiceUv?.progress ?: 0)
        editor.putString("tvIndiceUv", tvIndiceUv?.text.toString())

        editor.putBoolean("switchControl", switchMediciones?.isChecked ?: false)  // Guardar estado del Switch


        editor.apply()
    }

    // Restaurar los valores de SharedPreferences
    private fun restaurarValores() {
        val sharedPreferences = getSharedPreferences("MonitoreoPrefs", MODE_PRIVATE)

        pbConductividad?.progress = sharedPreferences.getInt("pbConductividad", 0)
        tvConductividad?.text = sharedPreferences.getString("tvConductividad", "")

        pbTds?.progress = sharedPreferences.getInt("pbTds", 0)
        tvTds?.text = sharedPreferences.getString("tvTds", "")

        pbTempAgua?.progress = sharedPreferences.getInt("pbTempAgua", 0)
        tvTempAgua?.text = sharedPreferences.getString("tvTempAgua", "")

        pbTempAire?.progress = sharedPreferences.getInt("pbTempAire", 0)
        tvTempAire?.text = sharedPreferences.getString("tvTempAire", "")

        pbHumedad?.progress = sharedPreferences.getInt("pbHumedad", 0)
        tvHumedad?.text = sharedPreferences.getString("tvHumedad", "")

        pbLuzVisible?.progress = sharedPreferences.getInt("pbLuzVisible", 0)
        tvLuzVisible?.text = sharedPreferences.getString("tvLuzVisible", "")

        pbLuzIr?.progress = sharedPreferences.getInt("pbLuzIr", 0)
        tvLuzIr?.text = sharedPreferences.getString("tvLuzIr", "")

        pbIndiceUv?.progress = sharedPreferences.getInt("pbIndiceUv", 0)
        tvIndiceUv?.text = sharedPreferences.getString("tvIndiceUv", "")

        val switchEstado = sharedPreferences.getBoolean("switchControl", false)
        switchMediciones?.isChecked = switchEstado  // Restaurar el estado del Switch
    }



    fun guardar(view: View) {
        // Guardar los datos en la base de datos
        //ejemplo de como se veran las barras
        pbConductividad?.progress = (pbConductividad?.progress?.plus(30))?.coerceAtMost(1000)!!
        tvConductividad?.text = "${pbConductividad?.progress} Us/Cm"

        pbTds?.progress = (pbTds?.progress?.plus(20))?.coerceAtMost(1000)!!
        tvTds?.text = "${pbTds?.progress} ppm"

        pbTempAgua?.progress = (pbTempAgua?.progress?.plus(5))?.coerceAtMost(80)!!
        tvTempAgua?.text = "${pbTempAgua?.progress} °C"

        pbTempAire?.progress = (pbTempAire?.progress?.plus(15))?.coerceAtMost(80)!!
        tvTempAire?.text = "${pbTempAire?.progress} °C"

        pbHumedad?.progress = (pbHumedad?.progress?.plus(5))?.coerceAtMost(100)!!
        tvHumedad?.text = "${pbHumedad?.progress} %"

        pbLuzVisible?.progress = (pbLuzVisible?.progress?.plus(50))?.coerceAtMost(700)!!
        tvLuzVisible?.text = "${pbLuzVisible?.progress} nm"

        pbLuzIr?.progress = (pbLuzIr?.progress?.plus(50))?.coerceAtMost(700)!!
        tvLuzIr?.text = "${pbLuzIr?.progress} lx"

        pbIndiceUv?.progress = (pbIndiceUv?.progress?.plus(1))?.coerceAtMost(10)!!
        tvIndiceUv?.text = "${pbIndiceUv?.progress} UVI"

    }

    fun irGraficas(view: View) {
        guardarValores()  // Guardar valores antes de cambiar de actividad
        // Ir a la actividad de monitoreo
        val siguiente = Intent(this, Graficas::class.java)
        startActivity(siguiente)
        val options = ActivityOptions.makeSceneTransitionAnimation(this)
        startActivity(siguiente, options.toBundle())
    }

    fun irTablas(view: View) {
        guardarValores()  // Guardar valores antes de cambiar de actividad
        // Ir a la actividad de tablas
        val siguiente = Intent(this, Tablas::class.java)
        startActivity(siguiente)
        val options = ActivityOptions.makeSceneTransitionAnimation(this)
        startActivity(siguiente, options.toBundle())
    }
}