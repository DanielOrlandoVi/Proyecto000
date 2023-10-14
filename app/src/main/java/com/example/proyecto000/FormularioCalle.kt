package com.example.proyecto000

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.content.Context
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ScrollView
import android.widget.Spinner
import android.widget.TextView
import androidx.fragment.app.DialogFragment


class FormularioCalle() : DialogFragment() {

    var FormularioCallesListener: FormularioCalleListener? = null
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

        builder.setTitle("Completa los datos")
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
        val spinner12 = Spinner(requireContext())
        val spinner13 = Spinner(requireContext())
        val opciones1 = arrayOf(
            "No presenta",
            "Reja Melatica",
            "talanquera",
            "delineadores",
            "estructura metalica",
            "cerca viva",
            "en rejas y alambre"
        )
        val opciones2 = arrayOf(
            "Buena",
            "Regular",
            "Mala",
            "deteriorada",
            "oxidada"
        )
        val opciones3 = arrayOf("si", "no")
        val opciones4 = arrayOf(
            "concreto",
            "Adoquin",
            "baldosa",
            "afirmado"
        )
        //Recordar los pisos tomarlos del input
        //Opciones para los pisos
        val opciones5 = arrayOf("con bordillo en concreto ","sin bordillo en concreto")
        val opciones6 = arrayOf("N/A", "si")
        val opciones7 = arrayOf(
            "Buena",
            "Regular",
            "Mala",
            "deteriorado",
            "presenta fisura",
            "se evidencia perdida de material"
        )
        val opciones8 = arrayOf(
            "N/A",
            "Zona blanda",
            "Zona verde",
            "Zona en adoquin",
            "Zona en afirmado"
        )
        val opciones9 = arrayOf(
            "N/A",
            "Empozamientos",
            "hundimiento de material de revestimiento",
            "desportillamientos generalizados"
        )

        val opciones10 = arrayOf(
            "N/A",
            "caneca metálica de residuos sólidos",
            "jardineras de ladrillo prensado",
            "contenedor de basura",
            "Bolardos"
        )


        val opciones11 = arrayOf(
            "N/A",
            "Plantas",
            "jardin",

        )
        val opciones12 = arrayOf(
            "Buena",
            "Regular",
            "Mala"
        )
        val opciones13 = arrayOf(
            "N/A",
            "caneca metálica de residuos sólidos",
            "jardineras de ladrillo prensado",
            "contenedor de basura",
            "Bolardos"
        )

        val opciones14 = arrayOf(
            "N/A",
            "Buena",
            "Regular",
            "Mala"
        )
        val opciones15 = arrayOf(
            "N/A",
            "Reja",
            "Puerta metalica",
            "talanquera"

        )

        val opciones16 = arrayOf( //USar 3 veces
            "N/A",
            "Buena",
            "Regular",
            "Mala",
            "presenta fisuras y desportillamiento",
            "desgaste generalizado por uso"
        )
        val opciones17 = arrayOf(
            "N/A",
            "en buenas condiciones ",
            "Regular",

        )

        val opciones_material_Rampa = arrayOf(
            "N/A",
            "asfalto",
            "rigido",
            "adoquin",
            "afirmado"
            )


        //Fin opciones pisos


            val titulo_Tipodeuso = TextView(requireContext())
            titulo_Tipodeuso.text = "presenta cerramiento, Tipo" // Puedes personalizar el texto del título
            linearLayout.addView(titulo_Tipodeuso)
            //Spinner 1
            val spinner_Array1 = opciones1 // Define las opciones del Spinner
            val spinner_Adapter1 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinner_Array1)
            spinner_Adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner1.adapter = spinner_Adapter1
            linearLayout.addView(spinner1)
            //Fin spinner1
            val titulo_TipoFachada = TextView(requireContext())
            titulo_TipoFachada.text = "en condiciones"
            linearLayout.addView(titulo_TipoFachada)

            //Spinner 2
            val spinner_Array2 = opciones2 // Define las opciones del Spinner
            val spinner_Adapter2 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinner_Array2)
            spinner_Adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner2.adapter = spinner_Adapter2
            linearLayout.addView(spinner2)
            //Fin spinner2
            val condicion_Fachada = TextView(requireContext())
            condicion_Fachada.text = "permite visibilidad al interior del cercado"
            linearLayout.addView(condicion_Fachada)
            //Spiner 3
            val spinner_Array3 = opciones3 // Define las opciones del Spinner
            val spinner_Adapter3 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinner_Array3)
            spinner_Adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner3.adapter = spinner_Adapter3
            linearLayout.addView(spinner3)

            val Presenta = TextView(requireContext())
            Presenta.text = "Con anden en"
            linearLayout.addView(Presenta)
            //Spiner 4
            val spinner_Array4 = opciones4 // Define las opciones del Spinner
            val spinner_Adapter4 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinner_Array4)
            spinner_Adapter3.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner4.adapter = spinner_Adapter4
            linearLayout.addView(spinner4)
            //Fin spinner 4
            val P_acceso = TextView(requireContext())
            P_acceso.text = "y se encuentra "
            linearLayout.addView(P_acceso)
            //Spiner 5
            val spinner_Array5 = opciones5 // Define las opciones del Spinner
            val spinner_Adapter5 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinner_Array5)
            spinner_Adapter5.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner5.adapter = spinner_Adapter5
            linearLayout.addView(spinner5)
            //Fin spinner 5
            //Spiner 6
            val Material = TextView(requireContext())
            Material.text = "cuenta con demarcación el bordillo"
            linearLayout.addView(Material)

            val spinner_Array6 = opciones6 // Define las opciones del Spinner
            val spinner_Adapter6 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinner_Array6)
            spinner_Adapter6.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner6.adapter = spinner_Adapter6
            linearLayout.addView(spinner6)
            //Fin spinner 6
            //Spinner 7
            val Venta_Material = TextView(requireContext())
            Venta_Material.text = "El estado del anden en general es" // Puedes personalizar el texto del título
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
            Venta_Esta.text = "el anden cuenta con secciones de " // Puedes personalizar el texto del título
            linearLayout.addView(Venta_Esta)
            val spinnerArray8 = opciones8 // Define las opciones del Spinner
            val spinnerAdapter8 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray8)
            spinnerAdapter8.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner8.adapter = spinnerAdapter8
            linearLayout.addView(spinner8)
            //Fin spinner 8
            //Spiner9
            val Vid_Esta = TextView(requireContext())
            Vid_Esta.text = "Algunas secciones del anden presentan condiciones de" // Puedes personalizar el texto del título
            linearLayout.addView(Vid_Esta)
            val spinnerArray9 = opciones9 // Define las opciones del Spinner
            val spinnerAdapter9 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray9)
            spinnerAdapter9.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner9.adapter = spinnerAdapter9
            linearLayout.addView(spinner9)
            //Fin spinner9
            //Spinner 10
            val Columnas = TextView(requireContext())
            Columnas.text = "se evidencia en el anden elementos urbanisticos   tales, como" // Puedes personalizar el texto del título
            linearLayout.addView(Columnas)
            val spinnerArray10 = opciones10 // Define las opciones del Spinner
            val spinnerAdapter10 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray10)
            spinnerAdapter10.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner10.adapter = spinnerAdapter10
            linearLayout.addView(spinner10)
            //Fin spinner 10

            //Spinner 11
            val Ventila = TextView(requireContext())
            Ventila.text = "presencia de plantas o jardin" // Puedes personalizar el texto del título
            linearLayout.addView(Ventila)
            val spinnerArray11 = opciones11 // Define las opciones del Spinner
            val spinnerAdapter11 =
                ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray11)
            spinnerAdapter11.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner11.adapter = spinnerAdapter11
            linearLayout.addView(spinner11)
            //Fin spinner11
        val Titulo_x = TextView(requireContext())
        Titulo_x.text = "condiciones de las plantas evidenciadas" // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_x)
        val spinnerArray12 = opciones12 // Define las opciones del Spinner
        val spinnerAdapter12 =
            ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray12)
        spinnerAdapter12.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner12.adapter = spinnerAdapter12
        linearLayout.addView(spinner12)


        // Crea el Spinner 13
        val Titulo_1 = TextView(requireContext())
        Titulo_1.text = "Se evidencia presencia de elementos arboreos" // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_1)

        val spinner_13 = Spinner(requireContext())
        val spinnerArray13 = opciones14 // Define las opciones del Spinner 13
        val spinnerAdapter13 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray13)
        spinnerAdapter13.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_13.adapter = spinnerAdapter13
        linearLayout.addView(spinner_13)

// Crea el Spinner 14
        val Titulo_2 = TextView(requireContext())
        Titulo_2.text = "Cuenta con acceso vehicular en tipo" // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_2)

        val spinner14 = Spinner(requireContext())
        val spinnerArray14 = opciones15 // Define las opciones del Spinner 14
        val spinnerAdapter14 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray14)
        spinnerAdapter14.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner14.adapter = spinnerAdapter14
        linearLayout.addView(spinner14)

// Crea el Spinner 15
        val Titulo_3 = TextView(requireContext())
        Titulo_3.text = "rampa en material" // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_3)
        val spinner15 = Spinner(requireContext())
        val spinnerArray15 = opciones_material_Rampa // Define las opciones del Spinner 15
        val spinnerAdapter15 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray15)
        spinnerAdapter15.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner15.adapter = spinnerAdapter15
        linearLayout.addView(spinner15)

        // Crea el Spinner 16

        val Titulo_4 = TextView(requireContext())
        Titulo_4.text = "condiciones de la rampa" // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_4)

        val spinner16 = Spinner(requireContext())
        val spinnerArray16 = opciones16 // Define las opciones del Spinner 16
        val spinnerAdapter16 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray16)
        spinnerAdapter16.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner16.adapter = spinnerAdapter16
        linearLayout.addView(spinner16)

        // Crea el Spinner spinner_aux1
        val Titulo_6 = TextView(requireContext())
        Titulo_6.text = "sardinel respecto a la rampa en condiciones " // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_6)

        val spinner_aux1 = Spinner(requireContext())
        val spinnerArray_aux1 = opciones16 // Utiliza las mismas opciones de opciones16
        val spinnerAdapter_aux1 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray_aux1)
        spinnerAdapter_aux1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_aux1.adapter = spinnerAdapter_aux1
        linearLayout.addView(spinner_aux1)

// Crea el Spinner spinner_aux2
        val Titulo_7 = TextView(requireContext())
        Titulo_7.text = "con varanda de acceso " // Puedes personalizar el texto del título
        linearLayout.addView(Titulo_7)
        val spinner_aux2 = Spinner(requireContext())
        val spinnerArray_aux2 = opciones14 // Utiliza las mismas opciones de opciones16
        val spinnerAdapter_aux2 = ArrayAdapter(requireContext(), R.layout.simple_spinner_item, spinnerArray_aux2)
        spinnerAdapter_aux2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        spinner_aux2.adapter = spinnerAdapter_aux2
        linearLayout.addView(spinner_aux2)
        scrollView.addView(linearLayout)
        // Agregar el ScrollView al AlertDialog




        builder.setView(scrollView)




        builder.setPositiveButton("Guardar") { dialog, _ ->
            val valorSpinner1 = reemplazarValor(spinner1.selectedItem.toString())
            val valorSpinner2 = reemplazarValor(spinner2.selectedItem.toString())
            val valorSpinner4 = reemplazarValor(spinner4.selectedItem.toString())
            val valorSpinner5 = reemplazarValor(spinner5.selectedItem.toString())
            val valorSpinner7 = reemplazarValor(spinner7.selectedItem.toString())
            val valorSpinner9 = reemplazarValor(spinner9.selectedItem.toString())
            val Envio_Texto = "Presenta cercamiento de tipo $valorSpinner1 la cual su estado es $valorSpinner2; " +
                    "El anden con zonas de $valorSpinner4 el cual esta $valorSpinner5 al igual que el sardinel,el estado general del anden es $valorSpinner7," +
                    "algunas secciones del anden presentan condiciones de $valorSpinner9,  "


             FormularioCallesListener?.Gemerar(Envio_Texto)






        }

        return builder.create()
    }
}

interface FormularioCalleListener {
    fun Gemerar(Texto :String)
}

class FormularioCalles : DialogFragment() {
    var FormularioCallesListener: FormularioCalleListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        try {
            FormularioCallesListener = context as FormularioCalleListener
        } catch (e: ClassCastException) {
            throw ClassCastException(
                (context.toString() +
                        " debe implementar Listener")
            )
        }
    }

}

fun reemplazar(valor: String): String {
    return when (valor) {
        "N/A" -> "No presenta"
        "con" -> "Presenta"
        else -> valor
    }
}
