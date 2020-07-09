package com.davidmartinez.sesionroom.model.model


import androidx.room.RoomDatabase
import androidx.room.Database
@Database(entities = [Deudor::class],version = 1)
abstract class DeudorDatabase: RoomDatabase() {

    abstract  fun DeudorDAO():DeudorDAO


}