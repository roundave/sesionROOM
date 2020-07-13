package com.davidmartinez.sesionroom.model.model.local


import androidx.room.RoomDatabase
import androidx.room.Database
import com.davidmartinez.sesionroom.model.model.local.Deudor
import com.davidmartinez.sesionroom.model.model.local.DeudorDAO

@Database(entities = [Deudor::class],version = 1)
abstract class DeudorDatabase: RoomDatabase() {

    abstract  fun DeudorDAO(): DeudorDAO


}