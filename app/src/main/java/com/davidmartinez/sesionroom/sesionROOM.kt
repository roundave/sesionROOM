package com.davidmartinez.sesionroom

import  android.app.Application
import  androidx.room.Room
import com.davidmartinez.sesionroom.model.model.DeudorDatabase
import com.davidmartinez.sesionroom.model.model.UsuarioDatabase

class sesionROOM: Application() {

    companion object{
        lateinit var  database: DeudorDatabase
        lateinit var  database2: UsuarioDatabase

    }

    override fun onCreate() {
        super.onCreate()

        database2=Room.databaseBuilder(
            this,
            UsuarioDatabase::class.java,
            "Usuario_DB"
        ).allowMainThreadQueries()
            .build()

         database=Room.databaseBuilder(
            this,
            DeudorDatabase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()
    }

}