package com.example.proyecto000

import android.R
import android.app.AlertDialog
import android.app.Dialog
import android.os.Bundle
import android.text.InputType

import android.widget.EditText

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.FragmentManager


class CantidadPisosDialogFragment : DialogFragment()  {

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val builder = AlertDialog.Builder(requireActivity())

        builder.setTitle("Ingrese la cantidad de pisos")

        val input = EditText(requireContext())
        input.inputType = InputType.TYPE_CLASS_NUMBER
        builder.setView(input)

        builder.setPositiveButton("Aceptar") { dialog, _ ->
            val cantidadPisos = input.text.toString().toInt()
            createFormularioPorPisos(requireActivity().supportFragmentManager, cantidadPisos)
        }

        return builder.create()
    }
}

fun createFormularioPorPisos(fragmentManager: FragmentManager, cantidadPisos: Int) {
    for (i in 1..cantidadPisos) {
        val dialogFragment = PisoFormularioDialogFragment(i)

        // Establece el PisosFormularioListener en cada instancia

        dialogFragment.show(fragmentManager, "formulario_piso_$i")
    }
}






