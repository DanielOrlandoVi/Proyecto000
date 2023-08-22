package com.example.proyecto000

import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.pdf.PdfDocument
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.view.View
import android.widget.Button
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.UUID

class PdfActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pdf)
        val button = findViewById<Button>(R.id.btnpdf)

        button.setOnClickListener {
            val contentView = findViewById<View>(R.id.activity_content)

            // Captura la vista actual como un bitmap
            val screenshot = Bitmap.createBitmap(contentView.width, contentView.height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(screenshot)
            contentView.draw(canvas)

            // Crea el documento PDF
            val pdfDocument = PdfDocument()
            val pageInfo = PdfDocument.PageInfo.Builder(
                screenshot.width, screenshot.height, 1
            ).create()

            val page = pdfDocument.startPage(pageInfo)
            val pdfCanvas: Canvas = page.canvas

            pdfCanvas.drawBitmap(screenshot, 0f, 0f, null)
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
        }

    }



}