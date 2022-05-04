package com.example.moisspaz201710264parcial2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class DoctoresActualizarActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doctores_actualizar)

        val etCodigo = findViewById<EditText>(R.id.doc_modificar_ed_codigo)
        val etNombre = findViewById<EditText>(R.id.doc_modificar_ed_nombre)
        val etApellido = findViewById<EditText>(R.id.doc_modificar_ed_apellido)
        val etDireccion = findViewById<EditText>(R.id.doc_modificar_ed_direccion)
        val etTelefono = findViewById<EditText>(R.id.doc_modificar_ed_telefono)
        val btnGuardar = findViewById<Button>(R.id.doc_modificar_btn_guardar)
        val btnBuscar = findViewById<Button>(R.id.doc_modificar_btn_buscar)

        btnBuscar.setOnClickListener {
            val requestQueue = Volley.newRequestQueue(this)
            var url = "https://moises92.000webhostapp.com/doctores_residentes/buscar_doctores.php?"
            url +="Codigo="+etCodigo.text.toString()

            // Formulate the request and handle the response.
            val stringRequest = StringRequest(
                Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Do something with the response
                    //convertir la respuesta del sw con volley en un array para android
                    val jsonArray = JSONArray(response)
                    //obtener un elemento del array jsonArray
                    var objetoJson = JSONObject(jsonArray.getString(0))
                    etTelefono.setText(objetoJson.getString("Telefono"))
                    etDireccion.setText(objetoJson.getString("Direccion"))
                    etApellido.setText(objetoJson.getString("Apellido"))
                    etNombre.setText(objetoJson.getString("Nombre"))
                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this,"Error en el servicio web", Toast.LENGTH_SHORT).show()

                })

            // Add the request to the RequestQueue.
            requestQueue.add(stringRequest)
        }

        btnGuardar.setOnClickListener {

            val requestQueue = Volley.newRequestQueue(this)
            var url = "https://moises92.000webhostapp.com/doctores_residentes/actualizar_doctores.php?"
            url +="Codigo="+etCodigo.text.toString()
            url +="&Nombre="+ etNombre.text.toString()
            url +="&Apellido="+ etApellido.text.toString()
            url +="&Direccion="+ etDireccion.text.toString()
            url +="&Telefono="+ etTelefono.text.toString()

            // Formulate the request and handle the response.
            val stringRequest = StringRequest(Request.Method.GET, url,
                Response.Listener<String> { response ->
                    // Do something with the response
                    //convertir la respuesta del sw con volley en un array para android
                    val jsonArray = JSONArray(response)
                    //obtener un elemento del array jsonArray
                    var objetoJson = JSONObject(jsonArray.getString(0))

                    Toast.makeText(this,"Datos Modificados Exitosamente", Toast.LENGTH_SHORT).show()


                },
                Response.ErrorListener { error ->
                    // Handle error
                    Toast.makeText(this,"Error en el servicio web", Toast.LENGTH_SHORT).show()

                })

            // Add the request to the RequestQueue.
            requestQueue.add(stringRequest)


        }
    }
}