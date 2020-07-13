package com.davidmartinez.sesionroom.model.model.local

import androidx.room.*
import com.davidmartinez.sesionroom.model.model.local.Deudor

@Dao
interface DeudorDAO{
    @Insert
    fun crearDeudor(deudor: Deudor)

    @Query("SELECT*FROM tabla_deudor where nombre LIKE :nombre ")
    fun BuscarDeudor(nombre: String): Deudor

    @Update
    fun actualizarDeudor(deudor: Deudor)

    @Delete
    fun borrarDeudor(deudor: Deudor)

    @Query("SELECT*FROM tabla_deudor")
    fun getDeudores(): List<Deudor>

}