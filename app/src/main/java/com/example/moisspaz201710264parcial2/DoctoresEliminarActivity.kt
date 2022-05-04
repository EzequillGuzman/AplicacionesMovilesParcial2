package com.example.moisspaz201710264parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class DoctoresEliminarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctores_eliminar)

        //Enlazar los controles de la vista
        val etId = findViewById<EditText>(R.id.doc_eliminar_et_codigo)
        val btnEliminar = findViewById<Button>(R.id.doc_eliminar_btn_eliminar)



        btnEliminar.setOnClickListener {
            val requestQueue = Volley.newRequestQueue(this)
            val url = "https://moises92.000webhostapp.com/doctores_residentes/eliminar_doctores.php?Codigo=" + etId.getText().toString()

            // Formulate the request and handle the response.
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    Toast.makeText(this,"Doctor Eliminado",Toast.LENGTH_SHORT).show()
                },
                Response.ErrorListener { error ->
                    Toast.makeText(this,"No se puede eliminar el registro",Toast.LENGTH_SHORT).show()

                })

            // Add the request to the RequestQueue.
            requestQueue.add(stringRequest)
        }

    }
}