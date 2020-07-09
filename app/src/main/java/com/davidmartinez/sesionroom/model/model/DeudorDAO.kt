package com.davidmartinez.sesionroom.model.model

import androidx.room.*

@Dao
interface DeudorDAO{
    @Insert
    fun crearDeudor(deudor: Deudor)

    @Query("SELECT*FROM tabla_deudor where nombre LIKE :nombre ")
    fun BuscarDeudor(nombre: String):Deudor

    @Update
    fun actualizarDeudor(deudor: Deudor)

    @Delete
    fun borrarDeudor(deudor: Deudor)

    @Query("SELECT*FROM tabla_deudor")
    fun getDeudores(): List<Deudor>

}