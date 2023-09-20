package com.example.proyecto000

import android.content.Intent
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import se.warting.signatureview.views.SignaturePad
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID


class FirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firm)

        //LLegada de los datos
        val Pdf_Name = intent.getStringExtra("Nombre_PDF")
        val Ruta = intent.getStringExtra("Ruta_PDF")
        val fecha = intent.getStringExtra("Fecha")
        val barrio = intent.getStringExtra("Barrio")
        val correo = intent.getStringExtra("Correo")
        val direccion = intent.getStringExtra("Direccion")
        val localidad = intent.getStringExtra("Localidad")
        val id = intent.getStringExtra("ID")
        val nombrePropietario = intent.getStringExtra("Nombre_Propietario")
        val telefonoPredio = intent.getStringExtra("Telefono_Predio")
        val ur1 = intent.getStringExtra("Ur1")
        val ur2 = intent.getStringExtra("Ur2")
        val ur3 = intent.getStringExtra("Ur3")

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




//Fin llegada.




        // Obtener la referencia a la vista de firma
        val signatureView = findViewById<View>(R.id.signature_pad) as SignaturePad

        // Obtener la referencia a los botones
        val clearButton = findViewById<Button>(R.id.clear_button)
        val saveButton = findViewById<Button>(R.id.save_button)



        // Añadir un listener al botón de borrar
        clearButton.setOnClickListener {
            // Borrar la firma
            signatureView.clear()
        }

        // Añadir un listener al botón de guardar
        saveButton.setOnClickListener {
            // Obtener el bitmap de la firma
            val signatureBitmap = signatureView.getSignatureBitmap()
            // Generar un UUID aleatorio
            val uuid = UUID.randomUUID().toString()

// Crear un archivo con el nombre del UUID
            val file = File(getExternalFilesDir("firms"), "$uuid.png")



            // Escribir el bitmap en el archivo usando un stream
            try {
                val stream = FileOutputStream(file)
                signatureBitmap.compress(Bitmap.CompressFormat.PNG, 100, stream)
                stream.flush()
                stream.close()
                showToast("Firma guardada con exito")
                signatureView.clear()
                val intent = Intent(this, PdfActivity::class.java)
                //Envio a firma
                intent.putExtra("Fecha", fecha)
                intent.putExtra("Barrio", barrio)
                intent.putExtra("Correo", correo)
                intent.putExtra("Direccion", direccion)
                intent.putExtra("Id", id)
                intent.putExtra("NombrePropietario", nombrePropietario)
                intent.putExtra("TelefonoPredio", telefonoPredio)
                intent.putExtra("Ur1", ur1)
                intent.putExtra("Ur2", ur2)
                intent.putExtra("Ur3", ur3)
                intent.putExtra("Localidad",localidad)
                intent.putExtra("Ruta_PDF",Ruta)
                intent.putExtra("Nombre_PDF",Pdf_Name)
                intent.putExtra("URI_firma",file.name)

                //Booleanos

                intent.putExtra("check_Agua", checkAgua)
                intent.putExtra("check_Alcantarillado", checkAlcantarillado)
                intent.putExtra("check_Energia", checkEnergia)
                intent.putExtra("check_Telefonos", checkTelefonos)
                intent.putExtra("check_Gas", checkGas)
                intent.putExtra("check_Tics", checkTics)
                intent.putExtra("check_Lconstruccion", checkLconstruccion)

                intent.putExtra("check_Residencial", checkResidencial)
                intent.putExtra("check_Comercial", checkComercial)
                intent.putExtra("check_Industrial", checkIndustrial)
                intent.putExtra("check_Institucional", checkInstitucional)
                intent.putExtra("check_Recreacional", checkRecreacional)
                intent.putExtra("check_Interescultural", checkInterescultural)
                intent.putExtra("check_Mixto", checkMixto)
                intent.putExtra("check_Otrouso", checkOtrouso)

                intent.putExtra("check_Garaje", checkGaraje)
                intent.putExtra("check_Usocomercial", checkUsocomercial)




                //Fin datos a enviar
                startActivity(intent)

            } catch (e: IOException) {
                e.printStackTrace()
            }




        }
    }


    private fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}