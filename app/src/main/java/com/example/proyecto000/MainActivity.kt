package com.example.proyecto000

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.util.Log
import android.view.MotionEvent
import android.view.View
import android.view.View.OnTouchListener
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import java.io.File


class MainActivity : AppCompatActivity(),PisosFormularioListener {
    lateinit var selectedUr1: Uri
    lateinit var selectedUr2: Uri
    lateinit var selectedUr3: Uri
    //Variables fotos
    val picMedia1 = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri->
        if(uri !=null){
            //Imagen seleccionado
            selectedUr1 = uri
            Foto1Viewer.setImageURI(uri)

        }else{
            //No imagen
            Log.i("aris","no seleccionado")
        }

    }

    lateinit var btn_foto1: Button
    lateinit var Foto1Viewer: ImageView


    val picMedia2 = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri->
        if(uri !=null){
            //Imagen seleccionado
            selectedUr2 = uri
            Foto2Viewer.setImageURI(uri)

        }else{
            //No imagen
            Log.i("aris","no seleccionado")
        }

    }

    lateinit var btn_foto2: Button
    lateinit var Foto2Viewer: ImageView


    val picMedia3 = registerForActivityResult(ActivityResultContracts.PickVisualMedia()){ uri->
        if(uri !=null){
            //Imagen seleccionado
            selectedUr3 = uri
            Foto3Viewer.setImageURI(uri)

        }else{
            //No imagen
            Log.i("aris","no seleccionado")
        }

    }

    lateinit var btn_foto3: Button
    lateinit var Foto3Viewer: ImageView







    //fin fotos

    lateinit var txtFecha: EditText //se crea una variable de tipo edición de texto que inicialmente es null
    var txtLocalidad: EditText?=null
    var txtBarrio: EditText?=null
    lateinit var txtIDdiseno: EditText
    var txtPropietariopredio: EditText?=null
    var txtTelefonopredio: EditText?=null
    var txtCorreopredio: EditText?=null
    lateinit var txtDireccionpredio: EditText
    var txtOtrouso: EditText?=null
    lateinit var txtDescripcion: EditText


    // Definir la variable checkboxes como una propiedad de la actividad

    // Checkboxes servicios
    private lateinit var estAgua: CheckBox
    private lateinit var estAlcantarillado: CheckBox
    private lateinit var estEnergia: CheckBox
    private lateinit var estTelefonos: CheckBox
    private lateinit var estGas: CheckBox
    private lateinit var estTics: CheckBox
    private lateinit var estLconstruccion: CheckBox


    // Checkboxes uso actual del predio
    private lateinit var estResidencial: CheckBox
    private lateinit var estComercial: CheckBox
    private lateinit var estIndustrial: CheckBox
    private lateinit var estInstitucional: CheckBox
    private lateinit var estRecreacional: CheckBox
    private lateinit var estInterescultural: CheckBox
    private lateinit var estMixto: CheckBox
    private lateinit var estOtrouso: CheckBox


    // Checkboxes uso vehicular
    private lateinit var estGaraje: CheckBox
    private lateinit var estUsocomercial: CheckBox


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)




        txtFecha = findViewById(R.id.txtFecha)//Esa variable la conectamos con el objeto del layout
        txtLocalidad = findViewById(R.id.txtLocalidad)
        txtBarrio = findViewById(R.id.txtBarrio)
        txtIDdiseno = findViewById(R.id.txtIDdiseno)
        txtPropietariopredio = findViewById(R.id.txtPropietariopredio)
        txtTelefonopredio = findViewById(R.id.txtTelefonopredio)
        txtCorreopredio = findViewById(R.id.txtCorreopredio)
        txtDireccionpredio = findViewById(R.id.txtDireccionpredio)
        txtOtrouso = findViewById(R.id.txtOtrouso)
        txtDescripcion = findViewById(R.id.txtDescripcion)


        //así permitimos el scroll del edittext desabilitando el scroll view padre
        txtDescripcion.setOnTouchListener(OnTouchListener { v, event ->
            if (txtDescripcion.hasFocus()) {
                v.parent.requestDisallowInterceptTouchEvent(true)
                when (event.action and MotionEvent.ACTION_MASK) {
                    MotionEvent.ACTION_SCROLL -> {
                        v.parent.requestDisallowInterceptTouchEvent(false)
                        return@OnTouchListener true
                    }
                }
            }
            false
        })

        //datePicker
        txtFecha.setOnClickListener {showDatePickerDialog()}


        //Fin DatePicker


        estAgua = findViewById(R.id.estAgua) //enlazo la variable con el checkbox del layout
        estAlcantarillado = findViewById(R.id.estAlcantarillado)
        estEnergia = findViewById(R.id.estEnergia)
        estTelefonos = findViewById(R.id.estTelefonos)
        estGas = findViewById(R.id.estGas)
        estTics = findViewById(R.id.estTics)
        estLconstruccion = findViewById(R.id.estLconstruccion)


        estResidencial = findViewById(R.id.estResidencial)
        estComercial = findViewById(R.id.estComercial)
        estIndustrial = findViewById(R.id.estIndustrial)
        estInstitucional = findViewById(R.id.estInstitucional)
        estRecreacional = findViewById(R.id.estRecreacional)
        estInterescultural = findViewById(R.id.estInterescultural)
        estMixto = findViewById(R.id.estMixto)
        estOtrouso = findViewById(R.id.estOtrouso)


        estGaraje = findViewById(R.id.estGaraje)
        estUsocomercial = findViewById(R.id.estUsocomercial)

        //Toma de fotos

        btn_foto1 = findViewById(R.id.foto1)
        Foto1Viewer = findViewById(R.id.imageView1)

        btn_foto2 = findViewById(R.id.foto2)
        Foto2Viewer = findViewById(R.id.imageView2)

        btn_foto3 = findViewById(R.id.foto3)
        Foto3Viewer = findViewById(R.id.imageView3)

        btn_foto1.setOnClickListener() {
            picMedia1.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        btn_foto2.setOnClickListener() {
            picMedia2.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }

        btn_foto3.setOnClickListener() {
            picMedia3.launch(PickVisualMediaRequest(ActivityResultContracts.PickVisualMedia.ImageOnly))
        }


        //fin toma de fotos

        var pref = getSharedPreferences(
            "datos_persona",
            Context.MODE_PRIVATE
        )//Para indicar que se muestre el mensaje de guardar hasta el final de la actividad

        var fecha = pref.getString(
            "fecha",
            ""
        ) //llamamos a Fecha y si esta vacio se devuelve un string vacio

        var localidad = pref.getString("localidad", "")

        var barrio = pref.getString("barrio", "")

        var iddiseno = pref.getString("iddiseno", "")

        var propietariopredio = pref.getString("propietariopredio", "")

        var telefonopredio = pref.getString("telefonopredio", "")

        var correopredio = pref.getString("correopredio", "")

        var direccionpredio = pref.getString("direccionpredio", "")

        var otrouso = pref.getString("otrouso", "")


        // Las siguientes variables temporales van a ser para que UNICAMENTE en descripcion
        // por default aparezcan _____ que estan guardados en esas variables temporales
        //de esta forma las variables que no son temporales muestran VACIO en los edittext y no
        //más _____

        // Si las variables son null o vacías, se reemplazan con "_" en las variables temporales
        val fechaTemp = fecha.takeIf { !it.isNullOrEmpty() } ?: "________"
        val localidadTemp = localidad.takeIf { !it.isNullOrEmpty() } ?: "________"
        val barrioTemp = barrio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val direccionpredioTemp = direccionpredio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val propietariopredioTemp = propietariopredio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val telefonopredioTemp = telefonopredio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val correopredioTemp = correopredio.takeIf { !it.isNullOrEmpty() } ?: "________"


        //A continuacion vamos a añadirle el texto template a descripción
        //texto con datos básicos, se edita lo necesario para darle al botón guardar de forma que finalmente la descripción queda completa y guardada
        val descripcion =
            "La información actualizada el $fechaTemp indica que el lugar se encuentra en la localidad de $localidadTemp, " +
                    "específicamente en el barrio $barrioTemp. La dirección exacta del lugar es $direccionpredioTemp. El propietario $propietariopredioTemp, " +
                    "puede ser contactado a través del número de teléfono $telefonopredioTemp o por el correo electrónico $correopredioTemp.\n" +
                    "El lugar se encuentra bajo las condiciones de …"


        //checkboxes servicios
        val defaultfalse =
            false //declaro un default en caso de que no se marque nada, en ese caso false
        val aguestado = pref.getBoolean(
            "aguaestado",
            defaultfalse
        ) //recupero el valor de aguaestado del shared preferences
        val alcantarilladoestado = pref.getBoolean("alcantarilladoestado", defaultfalse)
        val energiaestado = pref.getBoolean("energiaestado", defaultfalse)
        val telefonosestado = pref.getBoolean("telefonosestado", defaultfalse)
        val gasestado = pref.getBoolean("gasestado", defaultfalse)
        val ticsestado = pref.getBoolean("ticsestado", defaultfalse)
        val lconstruccionestado = pref.getBoolean("lconstruccionestado", defaultfalse)

        //checkboxes uso actual del predio

        val residencialestado = pref.getBoolean("residencialestado", defaultfalse)
        val comercialestado = pref.getBoolean("comercialestado", defaultfalse)
        val industrialestado = pref.getBoolean("industrialestado", defaultfalse)
        val institucionalestado = pref.getBoolean("institucionalestado", defaultfalse)
        val recreacionalestado = pref.getBoolean("recreacionalestado", defaultfalse)
        val interesculturalestado = pref.getBoolean("interesculturalestado", defaultfalse)
        val mixtoestado = pref.getBoolean("mixtoestado", defaultfalse)
        val otrousoestado = pref.getBoolean("otrousoestado", defaultfalse)

        //checkboxes uso vehicular

        val garajeestado = pref.getBoolean("garajeestado", defaultfalse)
        val usocomercialestado = pref.getBoolean("usocomercialestado", defaultfalse)


        //muestro en pantalla los checkboxes para ver si se guardo correctamente
        estAgua.setChecked(aguestado)
        estAlcantarillado.setChecked(alcantarilladoestado)
        estEnergia.setChecked(energiaestado)
        estTelefonos.setChecked(telefonosestado)
        estGas.setChecked(gasestado)
        estTics.setChecked(ticsestado)
        estLconstruccion.setChecked(lconstruccionestado)

        estResidencial.setChecked(residencialestado)
        estComercial.setChecked(comercialestado)
        estIndustrial.setChecked(industrialestado)
        estInstitucional.setChecked(institucionalestado)
        estRecreacional.setChecked(recreacionalestado)
        estInterescultural.setChecked(interesculturalestado)
        estMixto.setChecked(mixtoestado)
        estOtrouso.setChecked(otrousoestado)

        estGaraje.setChecked(garajeestado)
        estUsocomercial.setChecked(usocomercialestado)


        txtFecha?.setText(fecha) //controlador de fecha para que se muestre en pantalla

        txtLocalidad?.setText(localidad)

        txtBarrio?.setText(barrio)

        txtIDdiseno?.setText(iddiseno)

        txtPropietariopredio?.setText(propietariopredio)

        txtTelefonopredio?.setText(telefonopredio)

        txtCorreopredio?.setText(correopredio)

        txtDireccionpredio?.setText(direccionpredio)

        txtOtrouso?.setText(otrouso)

        //persistencia de descripcion




            // ...





        //conectamos el boton firma para que redirija a la otra activity
        val btnFirma= findViewById<Button>(R.id.btnFirma)

        btnFirma.setOnClickListener {
            val Nombre_Carpeta =txtIDdiseno.text.toString()

            if (!Nombre_Carpeta.isEmpty()) {

                // Obtener la carpeta correspondiente
                val directory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), Nombre_Carpeta)

                // Verificar si la carpeta ya existe o crearla si no existe
                if (!directory.exists()) {
                    if (directory.mkdirs()) {
                        // Carpeta creada exitosamente
                        Toast.makeText(this, "Carpeta creada: $Nombre_Carpeta", Toast.LENGTH_SHORT).show()
                    } else {
                        // Error al crear la carpeta
                        Toast.makeText(this, "Error al crear la carpeta", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // La carpeta ya existe
                    Toast.makeText(this, "La carpeta ya existe: $Nombre_Carpeta", Toast.LENGTH_SHORT).show()
                }
            } else {
                // El campo de texto está vacío
                Toast.makeText(this, "Ingrese un nombre para la carpeta", Toast.LENGTH_SHORT).show()
            }

            val Nombre_PDF = Nombre_Carpeta+"_"+txtDireccionpredio.text.toString()

            Toast.makeText(this, "R= $Nombre_Carpeta , N= $Nombre_PDF", Toast.LENGTH_SHORT).show()


            val intent = Intent(this, FirmActivity::class.java)
            //Inicio Txt

            intent.putExtra("Ruta_PDF",Nombre_Carpeta)
            intent.putExtra("Nombre_PDF",Nombre_PDF)
            intent.putExtra("Fecha",txtFecha.text.toString())
            intent.putExtra("Localidad",txtLocalidad?.text.toString())
            intent.putExtra("Barrio", txtBarrio?.text.toString())
            intent.putExtra("Correo",txtCorreopredio?.text.toString())
            intent.putExtra("Direccion",txtDireccionpredio.text.toString() )
            intent.putExtra("ID",txtIDdiseno.text.toString() )
            intent.putExtra("Nombre_Propietario",txtPropietariopredio?.text.toString() )
            intent.putExtra("Telefono_Predio", txtTelefonopredio?.text.toString())
            intent.putExtra("Ur1",selectedUr1.toString())
            intent.putExtra("Ur2",selectedUr2.toString())
            intent.putExtra("Ur3",selectedUr3.toString())
            //Boleanos

            intent.putExtra("check_Agua", estAgua.isChecked)
            intent.putExtra("check_Alcantarillado", estAlcantarillado.isChecked)
            intent.putExtra("check_Energia", estEnergia.isChecked)
            intent.putExtra("check_Telefonos", estTelefonos.isChecked)
            intent.putExtra("check_Gas", estGas.isChecked)
            intent.putExtra("check_Tics", estTics.isChecked)
            intent.putExtra("check_Lconstruccion", estLconstruccion.isChecked)

            intent.putExtra("check_Residencial", estResidencial.isChecked)
            intent.putExtra("check_Comercial", estComercial.isChecked)
            intent.putExtra("check_Industrial", estIndustrial.isChecked)
            intent.putExtra("check_Institucional", estInstitucional.isChecked)
            intent.putExtra("check_Recreacional", estRecreacional.isChecked)
            intent.putExtra("check_Interescultural", estInterescultural.isChecked)
            intent.putExtra("check_Mixto", estMixto.isChecked)
            intent.putExtra("check_Otrouso", estOtrouso.isChecked)

            intent.putExtra("check_Garaje", estGaraje.isChecked)
            intent.putExtra("check_Usocomercial", estUsocomercial.isChecked)



            //Fin txt

            startActivity(intent)

        }

    }

    private fun showDatePickerDialog() {

        val datePicker = DatePickerFragment {day,month,year->onDateSelected( day, month , year)}
        datePicker.show(supportFragmentManager, "DatePicker")


    }
    fun onDateSelected(day:Int,month:Int,year:Int){
        txtFecha.setText("$day/$month/$year")
    }






    fun guardar(view: View){ //al bttn no lo declaramos porque lo vamos a llamar con la función guardar
        var pref=getSharedPreferences("datos_persona", Context.MODE_PRIVATE) //aquí vamos a guardar los datos en la llave principal datos_persona de forma privada
        var editor=pref.edit() //creamos una variable editor en la que indicamos que vamos a editar lo que haya en pref



        //Guardado de los datos base
        editor.putString("fecha", txtFecha?.text.toString()) //ahora si en editor vamos a guardar los datos en este caso fecha primero el nombre de donde queremos guardar y luego la ubicacion y el como se quiere guardar (txt)
        editor.putString("localidad", txtLocalidad?.text.toString())
        editor.putString("barrio", txtBarrio?.text.toString())
        editor.putString("iddiseno", txtIDdiseno?.text.toString())
        editor.putString("propietariopredio", txtPropietariopredio?.text.toString())
        editor.putString("telefonopredio", txtTelefonopredio?.text.toString())
        editor.putString("correopredio", txtCorreopredio?.text.toString())
        editor.putString("direccionpredio", txtDireccionpredio?.text.toString())
        editor.putString("otrouso", txtOtrouso?.text.toString())


        // Guardado de estado Checkboxes
        val aguaestado= estAgua.isChecked
        val alcantarilladoestado= estAlcantarillado.isChecked
        val energiaestado= estEnergia.isChecked
        val telefonosestado= estTelefonos.isChecked
        val gasestado= estGas.isChecked
        val ticsestado= estTics.isChecked
        val lconstruccionestado= estLconstruccion.isChecked


        val residencialestado= estResidencial.isChecked
        val comercialestado= estComercial.isChecked
        val industrialestado= estIndustrial.isChecked
        val institucionalestado= estInstitucional.isChecked
        val recreacionalestado= estRecreacional.isChecked
        val interesculturalestado= estInterescultural.isChecked
        val mixtoestado= estMixto.isChecked
        val otrousoestado= estOtrouso.isChecked

        val garajeestado= estGaraje.isChecked
        val usocomercialestado= estUsocomercial.isChecked


        var descripcion = findViewById<EditText>(R.id.txtDescripcion)


        editor.putBoolean("aguaestado", aguaestado)
        editor.putBoolean("alcantarilladoestado", alcantarilladoestado)
        editor.putBoolean("energiaestado", energiaestado)
        editor.putBoolean("telefonosestado", telefonosestado)
        editor.putBoolean("gasestado", gasestado)
        editor.putBoolean("ticsestado", ticsestado)
        editor.putBoolean("lconstruccionestado", lconstruccionestado)

        editor.putBoolean("residencialestado", residencialestado)
        editor.putBoolean("comercialestado", comercialestado)
        editor.putBoolean("industrialestado", industrialestado)
        editor.putBoolean("institucionalestado", institucionalestado)
        editor.putBoolean("recreacionalestado", recreacionalestado)
        editor.putBoolean("interesculturalestado", interesculturalestado)
        editor.putBoolean("mixtoestado", mixtoestado)
        editor.putBoolean("otrousoestado", otrousoestado)

        editor.putBoolean("garajeestado", garajeestado)
        editor.putBoolean("usocomercialestado", usocomercialestado)




        //luego guardamos la descripcion dada por el que llena el fomulario
        editor.putString("descripcion", txtDescripcion?.text.toString()) //llevo el texto con la edicion base y la del usuario a editor
        //ya tenemos Fecha dentro de editor ahora vamos a mandar los datos

        editor.commit() //Enviamos los datos
        editor.apply() //Enviamos los datos del checkbox
        Toast.makeText(this,"Se guardaron los datos", Toast.LENGTH_LONG).show() //mostramos un mensaje de que si se guardaron
        Toast.makeText(this,"${descripcion.text}", Toast.LENGTH_LONG).show() //verifico que la DESCRIPCION COMPLETA Y FINAL se guarda correctamente

    }

    fun actualizar(view: View){

        //en el override sacabamos automaticamente los datos con persistencia al INICIARSE la app, aquí lo que hacemos es
        //que al darse el evento actualizar, pase se actualice unicamente la descripción, para eso tenemos que volver a llamar los datos
        txtFecha=findViewById(R.id.txtFecha)//Esa variable la conectamos con el objeto del layout
        txtLocalidad=findViewById(R.id.txtLocalidad)
        txtBarrio=findViewById(R.id.txtBarrio)
        txtDireccionpredio=findViewById(R.id.txtDireccionpredio)
        txtPropietariopredio=findViewById(R.id.txtPropietariopredio)
        txtTelefonopredio=findViewById(R.id.txtTelefonopredio)
        txtCorreopredio= findViewById(R.id.txtCorreopredio)


        var pref= getSharedPreferences("datos_persona", Context.MODE_PRIVATE)//Para indicar que se muestre el mensaje de guardar hasta el final de la actividad

        var fecha= pref.getString("fecha","") //llamamos a Fecha y si esta vacio se devuelve un string vacio

        var localidad= pref.getString("localidad","")

        var barrio= pref.getString("barrio","")

        var direccionpredio= pref.getString("direccionpredio","")

        var propietariopredio= pref.getString("propietariopredio","")

        var telefonopredio= pref.getString("telefonopredio", "")

        var correopredio= pref.getString("correopredio", "")


        var descripcion = findViewById<EditText>(R.id.txtDescripcion)

        //al darle actualizar se edita el texto template primero con los datos base y luego por lo que el usuario vea necesario

        //en caso de que vea un vacio al darle actualizar que lo señalize con raya al piso
        val fechaTemp = fecha.takeIf { !it.isNullOrEmpty() } ?: "________"
        val localidadTemp = localidad.takeIf { !it.isNullOrEmpty() } ?: "________"
        val barrioTemp = barrio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val direccionpredioTemp= direccionpredio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val propietariopredioTemp= propietariopredio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val telefonopredioTemp= telefonopredio.takeIf { !it.isNullOrEmpty() } ?: "________"
        val correopredioTemp= correopredio.takeIf { !it.isNullOrEmpty() } ?: "________"

        descripcion.setText("La información actualizada el $fechaTemp indica que el lugar se encuentra en la localidad de $localidadTemp, " +
                "específicamente en el barrio $barrioTemp. La dirección exacta del lugar es $direccionpredioTemp. El propietario $propietariopredioTemp, " +
                "puede ser contactado a través del número de teléfono $telefonopredioTemp o por el correo electrónico $correopredioTemp.\n" +
                "El lugar se encuentra bajo las condiciones de …")

        Toast.makeText(this,"${descripcion.text}", Toast.LENGTH_LONG).show() //vemos si el texto template con datos concatenados que guarda descripcion es el correcto

    }


    fun guardaryactualizar(view: View) {
        val dialogFragment = CantidadPisosDialogFragment()
        dialogFragment.show(supportFragmentManager, "formulario_dialog")
    }

    override fun onDatosPisosConfirmados(datoPisos: String) {

        Toast.makeText(this, "Dato de pisos recibido: $datoPisos", Toast.LENGTH_SHORT).show()

    }

    //se tiene que crear una función para el boton generar PDF en donde se llame a guardar y se guarder todos los datos en general
    //esta función pues llama a guardar()


    /*
    * 1.Función pasar a _____ al darle guardar de forma que la start screen este en ______
    * 2.Función actualizar con set Text y $fecha $localidad y unirlo con boton
    * */
}