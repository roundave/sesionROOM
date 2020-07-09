package com.davidmartinez.sesionroom.ui.update

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.Fragment
import com.davidmartinez.sesionroom.R
import com.davidmartinez.sesionroom.model.model.Deudor
import com.davidmartinez.sesionroom.model.model.DeudorDAO
import com.davidmartinez.sesionroom.sesionROOM
import kotlinx.android.synthetic.main.fragment_update.*

class updateFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val root = inflater.inflate(R.layout.fragment_update, container, false)
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        et_telefono.visibility=View.GONE
        et_cantidad.visibility=View.GONE
        bt_actualizar.visibility=View.GONE
        var idDeudor=0
        val deudorDAO: DeudorDAO=sesionROOM.database.DeudorDAO()

        bt_buscar.setOnClickListener {
            val nombre=et_nombre.text.toString()

            val deudor=deudorDAO.BuscarDeudor(nombre)

            if(deudor!=null){
                idDeudor=deudor.id
                et_telefono.visibility=View.VISIBLE
                et_cantidad.visibility=View.VISIBLE
                et_telefono.setText(deudor.telefono)
                et_cantidad.setText(deudor.cantidad.toString())
                bt_actualizar.visibility=View.VISIBLE
                bt_buscar.visibility=View.GONE
            }
        }

        bt_actualizar.setOnClickListener {
            val deudor=Deudor(idDeudor, et_nombre.text.toString(), et_telefono.text.toString(), et_cantidad.text.toString())
            deudorDAO.actualizarDeudor(deudor)
        }

    }
}