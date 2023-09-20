package com.example.proyecto000

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import android.widget.ScrollView
import android.widget.LinearLayout
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView

class PisoFormularioDialogFragment(private val numeroPiso: Int) : DialogFragment() {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())

        // Crear el ScrollView
        val scrollView = ScrollView(requireContext())
        val layoutParams = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.MATCH_PARENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )


        val linearLayout = LinearLayout(requireContext())
        linearLayout.orientation = LinearLayout.VERTICAL
        linearLayout.layoutParams = layoutParams

        builder.setTitle("Formulario para Piso $numeroPiso")
        val spinner1 = Spinner(requireContext())
        val spinner2 = Spinner(requireContext())
        val opciones1 = arrayOf("1.Residencial", "2.Comercial", "3.Industrial","4.institucional","5.Recreacional","7.Bien de interés cultural","8.Mixto","9.Otro?")
        val opciones2 = arrayOf("Opción 2-1", "Opción 2-2", "Opción 2-3")

        if (numeroPiso ==1){
            val titulo_Tipodeuso = TextView(requireContext())
            titulo_Tipodeuso.text = "Tipo de uso" // Puedes personalizar el texto del título
            linearLayout.addView(titulo_Tipodeuso)
            //Spinner 1
            val spinnerArray1 = opciones1 // Define las opciones del Spinner
            val spinnerAdapter1 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray1)
            spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = spinnerAdapter1
            linearLayout.addView(spinner1)
            //Fin spinner1

            val titulo_TipoFachada = TextView(requireContext())
            titulo_TipoFachada.text="Tipo de fachada"
            linearLayout.addView(titulo_TipoFachada)


            //Spinner 2
            val spinnerArray2 = opciones2 // Define las opciones del Spinner
            val spinnerAdapter2 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray2)
            spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = spinnerAdapter2
            linearLayout.addView(spinner2)
            //Fin spinner2





// Agregar el Spinner al LinearLayout



        }else{


        }


        scrollView.addView(linearLayout)

        // Agregar el ScrollView al AlertDialog
        builder.setView(scrollView)

        builder.setPositiveButton("Guardar") { dialog, _ ->
            // Manejar la lógica de guardar para este piso
        }

        return builder.create()
    }
}


