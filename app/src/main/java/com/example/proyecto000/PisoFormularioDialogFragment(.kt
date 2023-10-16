package com.example.proyecto000

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.fragment.app.DialogFragment
import android.widget.ScrollView
import android.widget.LinearLayout
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text

class PisoFormularioDialogFragment(private val numeroPiso: Int) : DialogFragment() {

    var pisosFormularioListener: PisosFormularioListener? = null
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())
        var Texto_generado = ""
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
        val spinner3 = Spinner(requireContext())
        val spinner4 = Spinner(requireContext())
        val spinner5 = Spinner(requireContext())
        val spinner6 = Spinner(requireContext())
        val spinner7 = Spinner(requireContext())
        val spinner8 = Spinner(requireContext())
        val spinner9 = Spinner(requireContext())
        val spinner10 = Spinner(requireContext())
        val spinner11 = Spinner(requireContext())
        val opciones1 = arrayOf(
            "1.Residencial",
            "2.Comercial",
            "3.Industrial",
            "4.institucional",
            "5.Recreacional",
            "7.Bien de interés cultural",
            "8.Mixto",
            "9.Otro?"
        )
        val opciones2 = arrayOf(
            "Ladrillo Prensado",
            "Tableta",
            "Estucada",
            "Bloque",
            "Estuco con pintura",
            "Con pañete",
            "Sin pañete "
        )
        val opciones3 = arrayOf("Buena", "Mala", "Regular")
        val opciones4 = arrayOf(
            "N/A",
            "Uso y desgaste natural por el tiempo de exposición la intemperie",
            "Grietas transversales expuestas",
            "Grietas logitudinales expuestas",
            "Grietas con  uso y desgaste natural por el tiempo de exposición la intemperie"
        )
        //Recordar los pisos tomarlos del input
        //Opciones para los pisos
        val opciones5 = arrayOf("Peatonal", "Vehicular", "Peatonal y Vehicular")
        val opciones6 = arrayOf("Metal", "Madera", "Maciso", "Seguridad", "Reja")
        val opciones7 = arrayOf("N/A", "Metal", "Madera")
        val opciones8 = arrayOf("N/A", "Buen Estado", "Vencido", "Roto")
        val opciones9 = arrayOf("N/A", "En concreto", "En madera")
        val opciones10 = arrayOf("N/A", "En material metalico", "Tubo pvc", "rejilla")


        //Pisos Formulario

        val opciones_1 = arrayOf("N/A", "con")
        val opciones_2 = arrayOf("N/A", "Metal", "Madera")
        val opciones_3 = arrayOf("N/A", "Bueno", "Regular", "Mala")
        val opciones_4 = arrayOf("N/A", "Buen Estado", "Vencido", "Roto")
        val opciones_5 = arrayOf("N/A", "Si")

        //Fin opciones pisos


        if (numeroPiso == 1) {
            val titulo_Tipodeuso = TextView(requireContext())
            titulo_Tipodeuso.text = "Tipo de uso" // Puedes personalizar el texto del título
            linearLayout.addView(titulo_Tipodeuso)
            //Spinner 1
            val spinnerArray1 = opciones1 // Define las opciones del Spinner
            val spinnerAdapter1 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray1)
            spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = spinnerAdapter1
            linearLayout.addView(spinner1)
            //Fin spinner1
            val titulo_TipoFachada = TextView(requireContext())
            titulo_TipoFachada.text = "Tipo de fachada"
            linearLayout.addView(titulo_TipoFachada)

            //Spinner 2
            val spinnerArray2 = opciones2 // Define las opciones del Spinner
            val spinnerAdapter2 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray2)
            spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = spinnerAdapter2
            linearLayout.addView(spinner2)
            //Fin spinner2
            val condicion_Fachada = TextView(requireContext())
            condicion_Fachada.text = "Tipo de fachada"
            linearLayout.addView(condicion_Fachada)
            //Spiner 3
            val spinnerArray3 = opciones3 // Define las opciones del Spinner
            val spinnerAdapter3 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray3)
            spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter = spinnerAdapter3
            linearLayout.addView(spinner3)

            val Presenta = TextView(requireContext())
            Presenta.text = "Presenta"
            linearLayout.addView(Presenta)
            //Spiner 4
            val spinnerArray4 = opciones4 // Define las opciones del Spinner
            val spinnerAdapter4 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray4)
            spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner4.adapter = spinnerAdapter4
            linearLayout.addView(spinner4)
            //Fin spinner 4
            val P_acceso = TextView(requireContext())
            P_acceso.text = "Puertas de acceso"
            linearLayout.addView(P_acceso)
            //Spiner 5
            val spinnerArray5 = opciones5 // Define las opciones del Spinner
            val spinnerAdapter5 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray5)
            spinnerAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner5.adapter = spinnerAdapter5
            linearLayout.addView(spinner5)
            //Fin spinner 5
            //Spiner 6
            val Material = TextView(requireContext())
            Material.text = "Material de la puerta"
            linearLayout.addView(Material)

            val spinnerArray6 = opciones6 // Define las opciones del Spinner
            val spinnerAdapter6 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray6)
            spinnerAdapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner6.adapter = spinnerAdapter6
            linearLayout.addView(spinner6)
            //Fin spinner 6

            //Color inicio
            // Título para el campo de color
            val colorTitle = TextView(requireContext())
            colorTitle.text = "Color" // Puedes personalizar el texto del título
            linearLayout.addView(colorTitle)

            // EditText para ingresar el color
            val colorEditText = EditText(requireContext())
            colorEditText.hint = "Ingrese un color" // Puedes personalizar el texto de sugerencia
            linearLayout.addView(colorEditText)
            //Color Final

            //Spinner 7
            val Venta_Material = TextView(requireContext())
            Venta_Material.text = "Material" // Puedes personalizar el texto del título
            linearLayout.addView(Venta_Material)
            val spinnerArray7 = opciones7 // Define las opciones del Spinner
            val spinnerAdapter7 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray7)
            spinnerAdapter7.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner7.adapter = spinnerAdapter7
            linearLayout.addView(spinner7)
            //Fin Spinner 7

            //Spinner 8
            val Venta_Esta = TextView(requireContext())
            Venta_Esta.text = "Estado Ventanas" // Puedes personalizar el texto del título
            linearLayout.addView(Venta_Esta)
            val spinnerArray8 = opciones3 // Define las opciones del Spinner
            val spinnerAdapter8 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray8)
            spinnerAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner8.adapter = spinnerAdapter8
            linearLayout.addView(spinner8)
            //Fin spinner 8
            //Spiner9
            val Vid_Esta = TextView(requireContext())
            Vid_Esta.text = "Estado Vidrio" // Puedes personalizar el texto del título
            linearLayout.addView(Vid_Esta)
            val spinnerArray9 = opciones8 // Define las opciones del Spinner
            val spinnerAdapter9 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray9)
            spinnerAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner9.adapter = spinnerAdapter9
            linearLayout.addView(spinner9)
            //Fin spinner9
            //Spinner 10
            val Columnas = TextView(requireContext())
            Columnas.text = "Columnas" // Puedes personalizar el texto del título
            linearLayout.addView(Columnas)
            val spinnerArray10 = opciones9 // Define las opciones del Spinner
            val spinnerAdapter10 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray10)
            spinnerAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner10.adapter = spinnerAdapter10
            linearLayout.addView(spinner10)
            //Fin spinner 10

            //Spinner 11
            val Ventila = TextView(requireContext())
            Ventila.text = "Ducto de ventilación" // Puedes personalizar el texto del título
            linearLayout.addView(Ventila)
            val spinnerArray11 = opciones10 // Define las opciones del Spinner
            val spinnerAdapter11 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray11)
            spinnerAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner11.adapter = spinnerAdapter11
            linearLayout.addView(spinner11)
            //Fin spinner11

        } else {

            val Titulo_1 = TextView(requireContext())
            Titulo_1.text = "Balcon" // Puedes personalizar el texto del título
            linearLayout.addView(Titulo_1)
            val spinnerArray1 = opciones_1 // Define las opciones del Spinner
            val spinnerAdapter1 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray1)
            spinnerAdapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = spinnerAdapter1
            linearLayout.addView(spinner1)

            val Titulo_2 = TextView(requireContext())
            Titulo_2.text = "Material ventanas" // Puedes personalizar el texto del título
            linearLayout.addView(Titulo_2)
            val spinnerArray2 = opciones_2 // Define las opciones del Spinner
            val spinnerAdapter2 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray2)
            spinnerAdapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = spinnerAdapter2
            linearLayout.addView(spinner2)

            // Título y Spinner 3
            val Titulo_3 = TextView(requireContext())
            Titulo_3.text = "Estado Ventanas" // Puedes personalizar el texto del título
            linearLayout.addView(Titulo_3)
            val spinnerArray3 = opciones_3 // Define las opciones del Spinner
            val spinnerAdapter3 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray3)
            spinnerAdapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter = spinnerAdapter3
            linearLayout.addView(spinner3)

// Título y Spinner 4
            val Titulo_4 = TextView(requireContext())
            Titulo_4.text = "Estado Vidrio" // Puedes personalizar el texto del título
            linearLayout.addView(Titulo_4)
            val spinnerArray4 = opciones_4 // Define las opciones del Spinner
            val spinnerAdapter4 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray4)
            spinnerAdapter4.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner4.adapter = spinnerAdapter4
            linearLayout.addView(spinner4)

// Título y Spinner 5
            val Titulo_5 = TextView(requireContext())
            Titulo_5.text = "Terreza" // Puedes personalizar el texto del título
            linearLayout.addView(Titulo_5)
            val spinnerArray5 = opciones_5 // Define las opciones del Spinner
            val spinnerAdapter5 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray5)
            spinnerAdapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner5.adapter = spinnerAdapter5
            linearLayout.addView(spinner5)

        }
        scrollView.addView(linearLayout)
        // Agregar el ScrollView al AlertDialog
        builder.setView(scrollView)

        builder.setPositiveButton("Guardar") { dialog, _ ->

            if (numeroPiso > 1) {

                val valorSpinner1 = reemplazarValor(spinner1.selectedItem.toString())
                val valorSpinner2 = reemplazarValor(spinner2.selectedItem.toString())
                val valorSpinner3 = reemplazarValor(spinner3.selectedItem.toString())
                val valorSpinner4 = reemplazarValor(spinner4.selectedItem.toString())
                val valorSpinner5 = reemplazarValor(spinner5.selectedItem.toString())


                if(listOf(valorSpinner1, valorSpinner2, valorSpinner3, valorSpinner4, valorSpinner5)
                       .all { it == "No presenta" }){

                   Texto_generado = ""


               }else{


                  Texto_generado= "En el piso ${numeroPiso.toString()} $"
               }

                pisosFormularioListener?.onDatosPisosConfirmados(Texto_generado)

            } else {
                val valorSpinner1 = reemplazarValor(spinner1.selectedItem.toString())
                val valorSpinner2 = reemplazarValor(spinner2.selectedItem.toString())
                val valorSpinner3 = reemplazarValor(spinner3.selectedItem.toString())
                val valorSpinner4 = reemplazarValor(spinner4.selectedItem.toString())
                val valorSpinner5 = reemplazarValor(spinner5.selectedItem.toString())
                val valorSpinner6 = reemplazarValor(spinner6.selectedItem.toString())
                val valorSpinner7 = reemplazarValor(spinner7.selectedItem.toString())
                val valorSpinner8 = reemplazarValor(spinner8.selectedItem.toString())
                val valorSpinner9 = reemplazarValor(spinner9.selectedItem.toString())
                val valorSpinner10 = reemplazarValor(spinner10.selectedItem.toString())



            }

        }



        return builder.create()
    }




}

interface PisosFormularioListener {
    fun onDatosPisosConfirmados(datoPisos: String)
}

fun reemplazarValor(valor: String): String {
    return when (valor) {
        "N/A" -> "No presenta"
        "con" -> "Presenta"
        else -> valor
    }
}

class PisosFormularioDialogFragment : DialogFragment() {
    var pisosFormularioListener: PisosFormularioListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            pisosFormularioListener = context as PisosFormularioListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                (context.toString() +
                        " debe implementar PisosFormularioListener")
            )
        }
    }

}

