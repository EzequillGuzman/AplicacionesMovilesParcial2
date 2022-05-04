package com.example.moisspaz201710264parcial2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnEliminar = findViewById<Button>(R.id.menu_btn_eliminar)
        val btnInsetar = findViewById<Button>(R.id.menu_btn_insertar)
        val btnModificar = findViewById<Button>(R.id.menu_btn_actualizar)
        val btnBusqueda = findViewById<Button>(R.id.btnBuscar)
        val btnCreditos = findViewById<Button>(R.id.btnCreditos)

        btnEliminar.setOnClickListener {
            val activityEliminarDoctores: Intent = Intent(this, DoctoresEliminarActivity::class.java)
            startActivity(activityEliminarDoctores)
        }
        btnInsetar.setOnClickListener {
            val activityInsertarDoctores: Intent = Intent(this, DoctoresInsertarActivity::class.java)
            startActivity(activityInsertarDoctores)
        }
        btnModificar.setOnClickListener {
            val activityActualizarDoctores: Intent = Intent(this, DoctoresActualizarActivity::class.java)
            startActivity(activityActualizarDoctores)
        }
        btnBusqueda.setOnClickListener {
            val activityBuscarDoctores: Intent = Intent(this, DoctoresBuscarActivity::class.java)
            startActivity(activityBuscarDoctores)

        }
        btnCreditos.setOnClickListener {
            val activityCreditos: Intent = Intent(this, Creditos::class.java)
            startActivity(activityCreditos)

        }


    }
}