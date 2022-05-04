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

class DoctoresInsertarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctores_insertar )

        //enlazar los elementos (vista con la lógica)
        val etCodigo = findViewById<EditText>(R.id.doc_agregar_ed_codigo)
        val etNombre = findViewById<EditText>(R.id.doc_agregar_ed_nombre)
        val etApellido = findViewById<EditText>(R.id.doc_agregar_ed_apellido)
        val etDireccion = findViewById<EditText>(R.id.doc_agregar_ed_direccion)
        val etTelefono = findViewById<EditText>(R.id.doc_agregar_ed_telefono)
        val btnGuardar = findViewById<Button>(R.id.doc_agregar_btn_guardar)

        btnGuardar.setOnClickListener {
            val requestQueue = Volley.newRequestQueue(this);
            val url = "https://moises92.000webhostapp.com/doctores_residentes/insertar_doctores.php?"
            url +="Codigo="+ etCodigo.getText().toString()
            url+="&Nombre="+ etNombre.getText().toString()
            url+="&Apellido="+ etApellido.getText().toString()
            url+="&Telefono=" + etTelefono.getText().toString()
            url+="&Direccion=" + etDireccion.getText().toString()



            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Do something with the response
                    Toast.makeText(this, "Doctor Insertado", Toast.LENGTH_SHORT).show()

                },
                Response.ErrorListener { error ->
                    // Handle error
                    //textView.text = "ERROR: %s".format(error.toString())
                    Toast.makeText(this, "Error al insertar", Toast.LENGTH_LONG).show()

                })

            // Add the request to the RequestQueue.
            requestQueue.add(stringRequest)


        }
    }
}