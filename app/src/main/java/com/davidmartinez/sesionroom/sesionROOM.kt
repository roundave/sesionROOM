package com.davidmartinez.sesionroom

import  android.app.Application
import  androidx.room.Room
import com.davidmartinez.sesionroom.model.model.DeudorDatabase

class sesionROOM: Application() {

    companion object{
        lateinit var  database: DeudorDatabase
    }

    override fun onCreate() {
        super.onCreate()

         database=Room.databaseBuilder(
            this,
            DeudorDatabase::class.java,
            "deudor_DB"
        ).allowMainThreadQueries()
            .build()
    }

}