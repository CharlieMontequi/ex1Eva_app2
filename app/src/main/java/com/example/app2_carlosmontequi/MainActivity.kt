package com.example.app2_carlosmontequi

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.widget.Toolbar
import java.time.LocalDateTime

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val toolbar = findViewById<Toolbar>(R.id.toolbar)
        setSupportActionBar(toolbar)

        val spinnerPrimero = findViewById<Spinner>(R.id.spn_primero)
        val spinnerSegundo = findViewById<Spinner>(R.id.spn_segundo)
        val spinnerTercero = findViewById<Spinner>(R.id.spn_tercero)
        val spinnerCuarto = findViewById<Spinner>(R.id.spn_cuarto)
        ArrayAdapter.createFromResource(
            this,
            R.array.array_numeros,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinnerPrimero.adapter = adapter
            spinnerSegundo.adapter = adapter
            spinnerTercero.adapter = adapter
            spinnerCuarto.adapter = adapter
        }

        val listado = findViewById<ListView>(R.id.lstV_opciones)


        // que el boton calcule
        val bt_Calcular = findViewById<Button>(R.id.bt_caclular)
        bt_Calcular.setOnClickListener() {
            recogerNumeros()

        }
    }

    /**
     * se habilita que el menu se muestre
     */
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.menu_layout, menu)
        return true
    }

    /**
     * se determina la accion para cada una de las opciones del menú
     */
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        val duracion = Toast.LENGTH_SHORT

        val mensajeEmergente: Toast

        when (item.itemId) {
            R.id.mItm_fecha -> {
                val fecha: LocalDateTime = LocalDateTime.now()
                mensajeEmergente = Toast.makeText(this, fecha.toString(), duracion)
                mensajeEmergente.show()
            }

            R.id.mItm_aceca -> {
                mensajeEmergente = Toast.makeText(this, R.string.info_acercaDe, duracion)
                mensajeEmergente.show()
            }

            else -> {
                return false
            }
        }
        return true
    }

    /**
     * recoge los numeros del spinner de izquierda a derecha
     * comprueba que no sea un cero en la primera posicion
     * muestra el numero resultante en el textview
     */
    fun recogerNumeros() {
        val spinnerPrimero = findViewById<Spinner>(R.id.spn_primero)
        val spinnerSegundo = findViewById<Spinner>(R.id.spn_segundo)
        val spinnerTercero = findViewById<Spinner>(R.id.spn_tercero)
        val spinnerCuarto = findViewById<Spinner>(R.id.spn_cuarto)
        val textoMostrar = findViewById<TextView>(R.id.txtv_prueba)

        var numeroSpinner: Double
        var textoNumero: String
        if (spinnerPrimero.selectedItem != 0) {
            textoNumero = spinnerPrimero.selectedItem.toString()
            textoNumero =
                textoNumero + spinnerSegundo.selectedItem.toString() + spinnerTercero.selectedItem.toString() + spinnerCuarto.selectedItem.toString()
        } else if (spinnerSegundo.selectedItem != 0) {
            textoNumero = spinnerSegundo.selectedItem.toString()
            textoNumero =
                textoNumero + spinnerTercero.selectedItem.toString() + spinnerCuarto.selectedItem.toString()
        } else if (spinnerTercero.selectedItem != 0) {
            textoNumero = spinnerTercero.toString()
            textoNumero = textoNumero + spinnerCuarto.selectedItem.toString()
        } else if (spinnerCuarto.selectedItem != 0) {
            textoNumero = spinnerCuarto.toString()
        } else {
            textoNumero = "0"
        }
        textoMostrar.text = textoNumero
        //numeroSpinner=Double.Parse(textoNumero)
        //    textoMostrar2.text=textoNumero
    }

    /**
     * comprueba si se ha recibido algun numero de la app1 y lo modifica
     */
    fun recibirNumeros() {

    }
}