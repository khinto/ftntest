package com.example.fitnessapplication.room

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [Ftn_Entity::class],version = 1)
abstract class AppDB:RoomDatabase()
{
    abstract fun getftnDAO():Ftn_DAO



}