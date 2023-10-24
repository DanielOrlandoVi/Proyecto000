package com.example.proyecto000

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import org.w3c.dom.Text
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID
import kotlin.math.min

class PdfActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)

        val button = findViewById<Button>(R.id.btnPDF)
        // Obtener el nombre del archivo de la firma del intent
        val ruta = intent.getStringExtra("Ruta_PDF")
        val nombre =intent.getStringExtra("Nombre_PDF")
        val fileName = intent.getStringExtra("URI_firma")

        // Crear una URI completa basada en el nombre del archivo
        val fileUri = Uri.fromFile(File(getExternalFilesDir("firms"), fileName))
        val fecha = intent.getStringExtra("Fecha")
        val barrio = intent.getStringExtra("Barrio")
        val correo = intent.getStringExtra("Correo")
        val direccion = intent.getStringExtra("Direccion")
        val id = intent.getStringExtra("Id")
        val nombrePropietario = intent.getStringExtra("NombrePropietario")
        val telefonoPredio = intent.getStringExtra("TelefonoPredio")
        val ur1 = intent.getStringExtra("Ur1")
        val ur2 = intent.getStringExtra("Ur2")
        val ur3 = intent.getStringExtra("Ur3")
        val localidad = intent.getStringExtra("Localidad")
        val textogenerado= intent.getStringExtra("Texto_Generado")
        val otrouso = intent.getStringExtra("otro_uso")

        //Variables Booleanos
        val checkAgua = intent.getBooleanExtra("check_Agua", false)
        val checkAlcantarillado = intent.getBooleanExtra("check_Alcantarillado", false)
        val checkEnergia = intent.getBooleanExtra("check_Energia", false)
        val checkTelefonos = intent.getBooleanExtra("check_Telefonos", false)
        val checkGas = intent.getBooleanExtra("check_Gas", false)
        val checkTics = intent.getBooleanExtra("check_Tics", false)
        val checkLconstruccion = intent.getBooleanExtra("check_Lconstruccion", false)

        val checkResidencial = intent.getBooleanExtra("check_Residencial", false)
        val checkComercial = intent.getBooleanExtra("check_Comercial", false)
        val checkIndustrial = intent.getBooleanExtra("check_Industrial", false)
        val checkInstitucional = intent.getBooleanExtra("check_Institucional", false)
        val checkRecreacional = intent.getBooleanExtra("check_Recreacional", false)
        val checkInterescultural = intent.getBooleanExtra("check_Interescultural", false)
        val checkMixto = intent.getBooleanExtra("check_Mixto", false)
        val checkOtrouso = intent.getBooleanExtra("check_Otrouso", false)

        val checkGaraje = intent.getBooleanExtra("check_Garaje", false)
        val checkUsocomercial = intent.getBooleanExtra("check_Usocomercial", false)





        //fin booleanos



        //Asignacion Imagenes y Variables
        val Firma_view: ImageView = findViewById(R.id.EditPDFFirmaPropietario)
        Firma_view.setImageURI(fileUri)

        val Foto1_view : ImageView = findViewById(R.id.EditPDFFotoFachada1)
        Foto1_view.setImageURI(Uri.parse(ur1))

        val Foto2_view : ImageView = findViewById(R.id.EditPDFFotoFachada2)
        Foto2_view.setImageURI(Uri.parse(ur2))

        val Foto3_view : ImageView = findViewById(R.id.EditPDFFotoFachada3)
        Foto3_view.setImageURI(Uri.parse(ur3))
        //Fin Imagenes

        //Inicio Textos
        val  Fecha : TextView = findViewById( R.id.EditPDFFecha)
        Fecha.setText(fecha)
        val Texto_fecha: TextView = findViewById(R.id.ViewPDFFechaLlenado)
        var textoFinal = Texto_fecha.text.toString()
        textoFinal= textoFinal+fecha
        Texto_fecha.setText(textoFinal)
        val Barrio : TextView = findViewById(R.id.EditPDFBarrio)
        Barrio.setText(barrio)
        val Correo : TextView = findViewById(R.id.EditPDFCorreo)
        Correo.setText(correo)
        val Direccion:TextView = findViewById(R.id.EditPDFDireccion)
        Direccion.setText(direccion)
        val ID : TextView = findViewById(R.id.EditPDFDiseno)
        ID.setText(id)
        val Nombre_Pro: TextView = findViewById(R.id.EditPDFNombrePropietario)
        Nombre_Pro.setText(nombrePropietario)
        val Telefono_Predio: TextView = findViewById(R.id.EditPDFTelefono)
        Telefono_Predio.setText(telefonoPredio)
        val Localidad: TextView = findViewById(R.id.EditPDFLocalidad)
        Localidad.setText(localidad)

        val texto: TextView =findViewById(R.id.EditPDFDescripcionPredio)
        texto.setText(textogenerado)

        val NombreProp : TextView = findViewById(R.id.EditPDFNombrePropietarioFirma)
        NombreProp.setText(nombrePropietario)

        val Otro_uso :TextView=findViewById(R.id.EditPDFCual)
        Otro_uso.setText(otrouso)


        //Fin textos

        //Inicio CheckBox
        val boxAgua: CheckBox = findViewById(R.id.CheckBoxSIAgua)
        val boxAlcantarillado: CheckBox = findViewById(R.id.CheckBoxSIAlcantarillado)
        val boxEnergia: CheckBox = findViewById(R.id.CheckBoxSIEnergia)
        val boxTelefonos: CheckBox = findViewById(R.id.CheckBoxSITelefonos)
        val boxGas: CheckBox = findViewById(R.id.CheckBoxSIGas)
        val boxTics: CheckBox = findViewById(R.id.CheckBoxSITics)

// CheckBoxes para uso actual del predio
        val boxResidencial: CheckBox = findViewById(R.id.CheckBoxResidencial)
        val boxComercial: CheckBox = findViewById(R.id.CheckBoxComercial)
        val boxIndustrial: CheckBox = findViewById(R.id.CheckBoxIndustrial)
        val boxInstitucional: CheckBox = findViewById(R.id.CheckBoxInstitucional)
        val boxRecreacional: CheckBox = findViewById(R.id.CheckBoxRecreacional)
        val boxInterescultural: CheckBox = findViewById(R.id.CheckBoxInteresCultural)
        val boxMixto: CheckBox = findViewById(R.id.CheckBoxMixto)
        val boxOtrouso: CheckBox = findViewById(R.id.CheckBoxOtro)



// CheckBoxes para uso vehicular
        val boxGaraje: CheckBox = findViewById(R.id.CheckBoxGaraje)
        val boxUsocomercial: CheckBox = findViewById(R.id.CheckBoxUsoComercial)
        val boxAgua_no: CheckBox = findViewById(R.id.CheckBoxNOAgua)
        val boxAlcantarillado_no: CheckBox = findViewById(R.id.CheckBoxNOAlcantarillado)
        val boxEnergia_no: CheckBox = findViewById(R.id.CheckBoxNOEnergia)
        val boxTelefonos_no: CheckBox = findViewById(R.id.CheckBoxNOTelefonos)
        val boxGas_no: CheckBox = findViewById(R.id.CheckBoxNOGas)
        val boxTics_no: CheckBox = findViewById(R.id.CheckBoxNOTics)
        val boxli_si: CheckBox = findViewById(R.id.CheckBoxSILicConstruccion)
        val boxli_no: CheckBox = findViewById(R.id.CheckBoxNOLicConstruccion)




        //Fin CheckBox
// CheckBoxes para servicios
        if (checkAgua) {
            boxAgua.isChecked = true
            boxAgua_no.isChecked = false
        } else {
            boxAgua_no.isChecked = true
            boxAgua.isChecked = false
        }

        if (checkAlcantarillado) {
            boxAlcantarillado.isChecked = true
            boxAlcantarillado_no.isChecked = false
        } else {
            boxAlcantarillado_no.isChecked = true
            boxAlcantarillado.isChecked = false
        }

        if (checkEnergia) {
            boxEnergia.isChecked = true
            boxEnergia_no.isChecked = false
        } else {
            boxEnergia_no.isChecked = true
            boxEnergia.isChecked = false
        }

        if (checkTelefonos) {
            boxTelefonos.isChecked = true
            boxTelefonos_no.isChecked = false
        } else {
            boxTelefonos_no.isChecked = true
            boxTelefonos.isChecked = false
        }

        if (checkGas) {
            boxGas.isChecked = true
            boxGas_no.isChecked = false
        } else {
            boxGas_no.isChecked = true
            boxGas.isChecked = false
        }

        if (checkTics) {
            boxTics.isChecked = true
            boxTics_no.isChecked = false
        } else {
            boxTics_no.isChecked = true
            boxTics.isChecked = false
        }
        if(checkLconstruccion){
         boxli_si.isChecked = true
         boxli_no.isChecked=false

        }else{
            boxli_si.isChecked = false
            boxli_no.isChecked= true
        }


// CheckBoxes para uso actual del predio
        if (checkResidencial) {
            boxResidencial.isChecked = true

        } else {

            boxResidencial.isChecked = false
        }

        if (checkComercial) {
            boxComercial.isChecked = true

        } else {

            boxComercial.isChecked = false
        }

        if (checkIndustrial) {
            boxIndustrial.isChecked = true

        } else {

            boxIndustrial.isChecked = false
        }

        if (checkInstitucional) {
            boxInstitucional.isChecked = true

        } else {

            boxInstitucional.isChecked = false
        }

        if (checkRecreacional) {
            boxRecreacional.isChecked = true

        } else {

            boxRecreacional.isChecked = false
        }

        if (checkInterescultural) {
            boxInterescultural.isChecked = true

        } else {

            boxInterescultural.isChecked = false
        }

        if (checkMixto) {
            boxMixto.isChecked = true

        } else {

            boxMixto.isChecked = false
        }

        if (checkOtrouso) {
            boxOtrouso.isChecked = true
        } else {
            boxOtrouso.isChecked = false
        }

// CheckBoxes para uso vehicular
        if (checkGaraje) {
            boxGaraje.isChecked = true
        } else {

            boxGaraje.isChecked = false
        }

        if (checkUsocomercial) {
            boxUsocomercial.isChecked = true

        } else {

            boxUsocomercial.isChecked = false
        }

        //Fin checkBox






        //Fin asignacion

        button.setOnClickListener {
            val contentView = findViewById<View>(R.id.activity_content)

            button.visibility= View.GONE

            // Captura la vista actual como un bitmap
            val screenshot = Bitmap.createBitmap(contentView.width, contentView.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(screenshot)
            contentView.draw(canvas)

// Escala el bitmap capturado al tamaño de oficio
            val oficioWidth = 5100 // Ancho en puntos
            val oficioHeight = 8400 // Alto en puntos (8.5 x 72)

            val scaleX = oficioWidth.toFloat() / screenshot.width
            val scaleY = oficioHeight.toFloat() / screenshot.height
            val scale = min(scaleX, scaleY)
            val scaledScreenshot = Bitmap.createScaledBitmap(
                screenshot,
                (screenshot.width * scale).toInt(),
                (screenshot.height * scale).toInt(),
                false
            )

// Crea el documento PDF
            val pdfDocument = PdfDocument()
            val pageInfo = PdfDocument.PageInfo.Builder(
                oficioWidth,
                oficioHeight,
                1
            ).create()

            val page = pdfDocument.startPage(pageInfo)
            val pdfCanvas: Canvas = page.canvas

// Configura la calidad de la imagen
            pdfCanvas.setDensity(440) // Ajusta este valor según tus necesidades

            pdfCanvas.drawBitmap(scaledScreenshot, 0f, 0f, null)
            pdfDocument.finishPage(page)

// Resto de tu código...

            // Directorio y archivo PDF
            val pdfDirectory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), ruta)
            pdfDirectory.mkdirs()


            val pdfFile = File(pdfDirectory, "$nombre.pdf")

            try {
                val fileOutputStream = FileOutputStream(pdfFile)
                pdfDocument.writeTo(fileOutputStream)
                fileOutputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }



            pdfDocument.close()


            button.visibility = View.VISIBLE
            // Una vez creado el PDF, puedes obtener la ruta
            val rutaDelPDF = pdfFile.absolutePath
            // Hacer lo que necesites con la ruta del PDF
            Toast.makeText(this, "PDF creado", Toast.LENGTH_SHORT).show()

        }
    }
}


