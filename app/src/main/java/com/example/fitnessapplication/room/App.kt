package com.example.fitnessapplication.room

import android.app.Application
import androidx.room.Room

class App : Application() {

    lateinit var db: AppDB

    companion object {
        lateinit var instance: App
            private set
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        db = Room.databaseBuilder(
            applicationContext,
            AppDB::class.java,
            "APP_DATABASE"
        ).allowMainThreadQueries().build()

    }

}