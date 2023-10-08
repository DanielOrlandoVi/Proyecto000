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
import androidx.fragment.app.FragmentManager
import java.io.File


class MainActivity : AppCompatActivity(),PisosFormularioListener,CantidadPisosListener {



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
        var texto =""



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


    fun guardaryactualizar(view: View) {
        val canDialogFragment = CantidadPisosDialogFragment()
        canDialogFragment.cantidadPisosListener= this
        canDialogFragment.show(supportFragmentManager,"Indica la cantidad de pisos del predio")
    }

    var aux =""
    override fun onDatosPisosConfirmados(datoPisos: String) {
        var descripcion = findViewById<EditText>(R.id.txtDescripcion)
         aux = aux+" "+datoPisos
        descripcion.setText("Se realiza acta de vencidad ubicado en predio ubicado en la direccion ${txtDireccionpredio.text} en el barrio ${txtBarrio?.text} el cual se encuentra en el siguiente estado: "+aux)

    }

    override fun onDatosCantidadPisos(NumeroPisos: Int) {
        createFormularioPorPisos(supportFragmentManager,NumeroPisos)
    }


    fun createFormularioPorPisos(fragmentManager: FragmentManager, cantidadPisos: Int) {
        for (i in 1..cantidadPisos) {
            val dialogFragment = PisoFormularioDialogFragment(i)
            dialogFragment.pisosFormularioListener= this

            // Establece el PisosFormularioListener en cada instancia

            dialogFragment.show(fragmentManager, "formulario_piso_$i")
        }
    }


    //se tiene que crear una función para el boton generar PDF en donde se llame a guardar y se guarder todos los datos en general
    //esta función pues llama a guardar()


    /*
    * 1.Función pasar a _____ al darle guardar de forma que la start screen este en ______
    * 2.Función actualizar con set Text y $fecha $localidad y unirlo con boton
    * */
}