package com.example.proyecto000

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import android.net.Uri
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
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
        val fileName = intent.getStringExtra("URI_firma")

        // Crear una URI completa basada en el nombre del archivo
        val fileUri = Uri.fromFile(File(getExternalFilesDir("firms"), fileName))

        // Mostrar la firma en el ImageView
        //val imageView: ImageView = findViewById(R.id.FirmaView)
        //imageView.setImageURI(fileUri)


        button.setOnClickListener {
            val contentView = findViewById<View>(R.id.activity_content)

            // Captura la vista actual como un bitmap
            val screenshot = Bitmap.createBitmap(contentView.width, contentView.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(screenshot)
            contentView.draw(canvas)

            // Escala el bitmap capturado al tamaño de oficio
            val oficioWidth = 5100 // Ancho en puntos
            val oficioHeight = 8400// Alto en puntos (8.5 x 72)

            val scaleX = oficioWidth.toFloat() / screenshot.width
            val scaleY = oficioHeight.toFloat() / screenshot.height
            val scale = min(scaleX, scaleY)
            val scaledScreenshot = Bitmap.createScaledBitmap(screenshot, (screenshot.width * scale).toInt(), (screenshot.height * scale).toInt(), false)

            // Crea el documento PDF
            val pdfDocument = PdfDocument()
            val pageInfo = PdfDocument.PageInfo.Builder(
                oficioWidth, oficioHeight, 1
            ).create()

            val page = pdfDocument.startPage(pageInfo)
            val pdfCanvas: Canvas = page.canvas

            pdfCanvas.drawBitmap(scaledScreenshot, 0f, 0f, null)
            pdfDocument.finishPage(page)

            // Directorio y archivo PDF
            val pdfDirectory = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOCUMENTS), "MyPDFs")
            pdfDirectory.mkdirs()

            val uuid = UUID.randomUUID().toString()
            val pdfFile = File(pdfDirectory, "$uuid.pdf")

            try {
                val fileOutputStream = FileOutputStream(pdfFile)
                pdfDocument.writeTo(fileOutputStream)
                fileOutputStream.close()
            } catch (e: IOException) {
                e.printStackTrace()
            }

            pdfDocument.close()

            // Una vez creado el PDF, puedes obtener la ruta
            val rutaDelPDF = pdfFile.absolutePath
            // Hacer lo que necesites con la ruta del PDF
        }
    }
}


