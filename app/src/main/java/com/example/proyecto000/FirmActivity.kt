package com.example.proyecto000

import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import se.warting.signatureview.views.SignaturePad
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID


class FirmActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_firm)

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
            } catch (e: IOException) {
                e.printStackTrace()
            }




        }
    }
}