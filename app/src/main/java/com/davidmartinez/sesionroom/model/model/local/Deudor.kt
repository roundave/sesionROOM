package com.davidmartinez.sesionroom.model.model.local

import  androidx.room.Entity
import  androidx.room.ColumnInfo
import  androidx.room.PrimaryKey

@Entity(tableName = "tabla_deudor")
class Deudor(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id") val id:Int,
    @ColumnInfo(name = "nombre") val nombre:String,
    @ColumnInfo(name = "Telefono") val telefono:String,
    @ColumnInfo(name = "Cantidad") val cantidad: Long
)


