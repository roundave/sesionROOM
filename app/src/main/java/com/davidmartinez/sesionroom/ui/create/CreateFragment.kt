package com.davidmartinez.sesionroom.ui.create

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.davidmartinez.sesionroom.R
import com.davidmartinez.sesionroom.model.model.local.Deudor
import com.davidmartinez.sesionroom.model.model.local.DeudorDAO
import com.davidmartinez.sesionroom.model.model.remote.DeudorRemote
import com.davidmartinez.sesionroom.sesionROOM
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_create.*
import java.sql.Types.NULL


class CreateFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val root = inflater.inflate(R.layout.fragment_create, container, false)

        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mostrarMensageBienvenida()





        bt_guardar.setOnClickListener {
            val nombre = et_nombre.text.toString()
            val telefono = et_telefono.text.toString()
            val cantidad = et_cantidad.text.toString().toLong()


            //guardarEnRoom(nombre, telefono, cantidad)
            guardarEnFirebase(nombre, telefono, cantidad)

            clearEditText()
        }
    }

    private fun guardarEnFirebase(nombre: String, telefono: String, cantidad: Long) {
        //base de datos con firebase
        val database = FirebaseDatabase.getInstance()
        val myRef = database.getReference("deudores")
        val id=myRef.push().key
        val deudor= DeudorRemote(
            id,
            nombre,
            telefono,
            cantidad
            )
        myRef.child(id!!).setValue(deudor)
        /////////////

    }

    private fun mostrarMensageBienvenida() {
        var mAuth: FirebaseAuth = FirebaseAuth.getInstance() // firebase
        val User: FirebaseUser? = mAuth.currentUser
        val correo = User?.email
        Toast.makeText(requireContext(), "Bienvenido $correo", Toast.LENGTH_SHORT).show()
    }



    private fun clearEditText() {
        et_nombre.setText("")
        et_telefono.setText("")
        et_cantidad.setText("")
    }

    private fun guardarEnRoom(
        nombre: String,
        telefono: String,
        cantidad: Long
    ) {

        val deudor = Deudor(
            NULL,
            nombre,
            telefono,
            cantidad
        )
        val deudorDAO: DeudorDAO = sesionROOM.database.DeudorDAO()
        deudorDAO.crearDeudor(deudor)
    }
}