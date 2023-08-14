package com.example.proyecto000

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    var txtFecha: EditText?=null //se crea una variable de tipo edición de texto que inicialmente es null
    var txtLocalidad: EditText?=null
    var txtBarrio: EditText?=null
    var txtIDdiseno: EditText?=null
    var txtPropietariopredio: EditText?=null
    var txtTelefonopredio: EditText?=null
    var txtCorreopredio: EditText?=null
    var txtDireccionpredio: EditText?=null
    var txtDescripcion: EditText?=null

    // Definir la variable checkboxes como una propiedad de la actividad
    /*private lateinit var checkboxes: Array<CheckBox>
    val AguaSi = findViewById<CheckBox>(R.id.AguaSi)
    val AguaNo = findViewById<CheckBox>(R.id.AguaNo)
    val AlcantarilladoSi = findViewById<CheckBox>(R.id.AlcantarilladoSi)
    val AlcantarilladoNo = findViewById<CheckBox>(R.id.AlcantarilladoNo)
    val EnergiaSi = findViewById<CheckBox>(R.id.EnergiaSi)
    val EnergiaNo = findViewById<CheckBox>(R.id.EnergiaNo)
    val TelefonosSi = findViewById<CheckBox>(R.id.TelefonosSi)
    val TelefonosNo = findViewById<CheckBox>(R.id.TelefonosNo)
    val GasSi = findViewById<CheckBox>(R.id.GasSi)
    val GasNo = findViewById<CheckBox>(R.id.GasNo)
    val TicsSi = findViewById<CheckBox>(R.id.TicsSi)
    val TicsNO = findViewById<CheckBox>(R.id.TicsNo)
    val LconstruccionSi = findViewById<CheckBox>(R.id.LconstruccionSi)
    val LconstruccionNo = findViewById<CheckBox>(R.id.LconstruccionNo)*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtFecha=findViewById(R.id.txtFecha)//Esa variable la conectamos con el objeto del layout
        txtLocalidad=findViewById(R.id.txtLocalidad)
        txtBarrio=findViewById(R.id.txtBarrio)
        txtIDdiseno=findViewById(R.id.txtIDdiseno)
        txtPropietariopredio=findViewById(R.id.txtPropietariopredio)
        txtTelefonopredio=findViewById(R.id.txtTelefonopredio)
        txtCorreopredio=findViewById(R.id.txtCorreopredio)
        txtDireccionpredio=findViewById(R.id.txtDireccionpredio)
        txtDescripcion=findViewById(R.id.txtDescripcion)


        //Primero declaremos los checkboxes


        // Inicializar la variable checkboxes con los checkboxes del layout


        /*checkboxes = arrayOf(AguaSi, AguaNo, AlcantarilladoSi, AlcantarilladoNo, EnergiaSi, EnergiaNo, TelefonosSi, TelefonosNo,
            GasSi, GasNo, TicsSi, TicsNO, LconstruccionSi, LconstruccionNo)*/


        var pref= getSharedPreferences("datos_persona", Context.MODE_PRIVATE)//Para indicar que se muestre el mensaje de guardar hasta el final de la actividad

        var fecha= pref.getString("fecha", "") //llamamos a Fecha y si esta vacio se devuelve un string vacio

        var localidad= pref.getString("localidad", "")

        var barrio= pref.getString("barrio", "")

        var iddiseno= pref.getString("iddiseno", "")

        var propietariopredio= pref.getString("propietariopredio", "")

        var telefonopredio= pref.getString("telefonopredio", "")

        var correopredio= pref.getString("correopredio", "")

        var direccionpredio= pref.getString("direccionpredio", "")



        ///A continuacion vamos a añadirle el texto template a descripción
        //texto con datos básicos, se edita lo necesario para darle al botón guardar de forma que finalmente la descripción final queda completa y guardada
        var descripcion = findViewById<EditText>(R.id.txtDescripcion)
        descripcion.setText("La fecha introducida es _______, la localidad es _______, el barrio es _______ .") //template

        var descripcionfinal = pref.getString("descripcion","") //como descripcion se usa como pivote con el template inicial descripcion final sera donde definitivamente se GUARDE la descripción para mandar al PDF

        txtFecha?.setText(fecha) //controlador de fecha para que se muestre en pantalla

        txtLocalidad?.setText(localidad)

        txtBarrio?.setText(barrio)

        txtIDdiseno?.setText(iddiseno)

        txtPropietariopredio?.setText(propietariopredio)

        txtTelefonopredio?.setText(telefonopredio)

        txtCorreopredio?.setText(correopredio)

        txtDireccionpredio?.setText(direccionpredio)


        txtDescripcion?.setText(descripcionfinal) //activar este metodo para ver si se guarda descripcionfinal




    }
    fun guardar(view: View){ //al bttn no lo declaramos porque lo vamos a llamar con la función guardar
        var pref=getSharedPreferences("datos_persona", Context.MODE_PRIVATE) //aquí vamos a guardar los datos en la llave principal datos_persona de forma privada
        var editor=pref.edit() //creamos una variable editor en la que indicamos que vamos a editar lo que haya en pref

        //primero guardamos los datos base
        editor.putString("fecha", txtFecha?.text.toString()) //ahora si en editor vamos a guardar los datos en este caso fecha primero el nombre de donde queremos guardar y luego la ubicacion y el como se quiere guardar (txt)
        editor.putString("localidad", txtLocalidad?.text.toString())
        editor.putString("barrio", txtBarrio?.text.toString())
        editor.putString("iddiseno", txtIDdiseno?.text.toString())
        editor.putString("propietariopredio", txtPropietariopredio?.text.toString())
        editor.putString("telefonopredio", txtTelefonopredio?.text.toString())
        editor.putString("correopredio", txtCorreopredio?.text.toString())
        editor.putString("direccionpredio", txtDireccionpredio?.text.toString())

        //guardemos los datos de los checkboxes
        /*for (i in checkboxes.indices) {
            val id = checkboxes[i].id
            val isChecked = pref.getBoolean("checkbox_$id", false)
            Log.d("Checkbox", "ID: $id, Estado: $isChecked")
        }*/

        //luego guardamos la descripcion dada por el que llena el fomulario
        editor.putString("descripcion", txtDescripcion?.text.toString()) //llevo el texto con la edicion base y la del usuario a editor
        //ya tenemos Fecha dentro de editor ahora vamos a mandar los datos
        editor.commit() //Enviamos los datos
        Toast.makeText(this,"Se guardaron los datos", Toast.LENGTH_LONG).show() //mostramos un mensaje de que si se guardaron


    }

    fun actualizar(view: View){

        //en el override sacabamos automaticamente los datos con persistencia al INICIARSE la app, aquí lo que hacemos es
        //que al darse el evento actualizar, pase se actualice unicamente la descripción, para eso tenemos que volver a llamar los datos
        txtFecha=findViewById(R.id.txtFecha)//Esa variable la conectamos con el objeto del layout
        txtLocalidad=findViewById(R.id.txtLocalidad)
        txtBarrio=findViewById(R.id.txtBarrio)

        var pref= getSharedPreferences("datos_persona", Context.MODE_PRIVATE)//Para indicar que se muestre el mensaje de guardar hasta el final de la actividad

        var fecha= pref.getString("fecha","") //llamamos a Fecha y si esta vacio se devuelve un string vacio

        var localidad= pref.getString("localidad","")

        var barrio= pref.getString("barrio","")

        var descripcion = findViewById<EditText>(R.id.txtDescripcion)

        //al darle actualizar se edita el texto template primero con los datos base y luego por lo que el usuario vea necesario
        descripcion.setText("La fecha introducida es $fecha, la localidad es $localidad, el barrio es $barrio .")
        Toast.makeText(this,"${descripcion.text}", Toast.LENGTH_LONG).show() //vemos si el texto que guarda descripcion es el correcto

    }


    fun guardaryactualizar(view: View) {
        guardar(view)
        actualizar(view)
    }



    /*
    * 1.Función pasar a _____ al darle guardar de forma que la start screen este en ______
    * 2.Función actualizar con set Text y $fecha $localidad y unirlo con boton
    * */
}