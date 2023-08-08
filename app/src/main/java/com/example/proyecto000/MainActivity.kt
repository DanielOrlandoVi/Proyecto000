package com.example.proyecto000

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.view.View
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var txtFecha: EditText?=null //se crea una variable de tipo edición de texto que inicialmente es null
    var txtLocalidad: EditText?=null
    var txtBarrio: EditText?=null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFecha=findViewById(R.id.txtFecha)//Esa variable la conectamos con el objeto del layout
        txtLocalidad=findViewById(R.id.txtLocalidad)
        txtBarrio=findViewById(R.id.txtBarrio)

        var pref= getSharedPreferences("datos_persona", Context.MODE_PRIVATE)//Para indicar que se muestre el mensaje de guardar hasta el final de la actividad

        var fecha= pref.getString("fecha","") //llamamos a Fecha y si esta vacio se devuelve un string vacio

        var localidad= pref.getString("localidad","")

        var barrio= pref.getString("barrio","")

        //txtFecha?.setText(fecha) //controlador de fecha para que se muestre en pantalla

        //txtLocalidad?.setText(localidad)

        //txtBarrio?.setText(barrio)

        ///A continuacion vamos a añadirle el texto template a descripción

        val txtDescripcion = findViewById<EditText>(R.id.txtDescripcion)

        val DescripcionTempate = "La fecha introducida es: "

        txtDescripcion.setText("La fecha introducida es $fecha, la localidad es $localidad") //condicional con evento


    }
    fun guardar(view: View){ //al bttn no lo declaramos porque lo vamos a llamar con la función guardar
        var pref=getSharedPreferences("datos_persona", Context.MODE_PRIVATE) //aquí vamos a guardar los datos en la llave principal datos_persona de forma privada
        var editor=pref.edit() //creamos una variable editor en la que indicamos que vamos a editar lo que haya en pref

        editor.putString("fecha", txtFecha?.text.toString()) //ahora si en editor vamos a guardar los datos en este caso fecha primero el nombre de donde queremos guardar y luego la ubicacion y el como se quiere guardar (txt)
        editor.putString("localidad", txtLocalidad?.text.toString())
        editor.putString("barrio", txtBarrio?.text.toString())

        //ya tenemos Fecha dentro de editor ahora vamos a mandar los datos
        editor.commit() //Enviamos los datos
        Toast.makeText(this,"Se guardaron los datos", Toast.LENGTH_LONG).show() //mostramos un mensaje de que si se guardaron

    }

    /*
    * 1.Función pasar a _____ al darle guardar de forma que la start screen este en ______
    * 2.Función actualizar con set Text y $fecha $localidad y unirlo con boton
    * */
}