package com.davidmartinez.sesionroom.ui.delete

import android.app.AlertDialog
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.davidmartinez.sesionroom.R
import com.davidmartinez.sesionroom.model.model.Deudor
import com.davidmartinez.sesionroom.sesionROOM
import kotlinx.android.synthetic.main.fragment_delete.*


class DeleteFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_delete, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bt_eliminar.setOnClickListener {
            val nombre=et_nombre.text.toString()
            val deudorDAO=sesionROOM.database.DeudorDAO()
            val Deudor=deudorDAO.BuscarDeudor(nombre)

            if(Deudor!=null) {
                val alertDialog: AlertDialog? = activity?.let {
                    val builder = AlertDialog.Builder(it)
                    builder.apply {
                        setMessage("Desea Elminar a " + Deudor.nombre + " su deuda es" + Deudor.cantidad + " ?")
                        setPositiveButton(
                            R.string.aceptar
                        ){dialog, id-> deudorDAO.borrarDeudor(Deudor)}
                        setNegativeButton(
                            R.string.cancelar
                        ){dialog, id ->  }
                        }
                    builder.create()
                    }
                if (alertDialog != null) {
                    alertDialog.show()
                }
                deudorDAO.borrarDeudor(Deudor)
            }else
                Toast.makeText(context, "Deudor no encontrado", Toast.LENGTH_SHORT).show()

        }

    }
}