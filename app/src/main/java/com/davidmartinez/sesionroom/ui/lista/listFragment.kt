package com.davidmartinez.sesionroom.ui.lista

import android.app.Activity
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.davidmartinez.sesionroom.DeudoresRVAdapter
import com.davidmartinez.sesionroom.R
import com.davidmartinez.sesionroom.model.model.Deudor
import com.davidmartinez.sesionroom.model.model.DeudorDAO
import com.davidmartinez.sesionroom.sesionROOM


class listFragment : Fragment() {
    var allDeudores: List<Deudor> = emptyList()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val root=inflater.inflate(R.layout.fragment_list, container, false)
        val rv_deudores=root.findViewById<RecyclerView>(R.id.rv_deudores)
        rv_deudores.layoutManager=LinearLayoutManager(
            requireActivity().applicationContext,
            RecyclerView.VERTICAL,
            false
        )
        rv_deudores.setHasFixedSize(true)
        var deudorDAO: DeudorDAO=sesionROOM.database.DeudorDAO()
        allDeudores=deudorDAO.getDeudores()
        var deudoresRVAdapter=DeudoresRVAdapter(
            requireActivity().applicationContext,
            allDeudores as ArrayList<Deudor>
            )
        rv_deudores.adapter=deudoresRVAdapter
        deudoresRVAdapter.notifyDataSetChanged()
        return root
    }


}