package com.example.fitnessapplication.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query




@Dao
interface Ftn_DAO

    {


        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(vararg ftn:Ftn_Entity)

        @Query("select * from Ftn_Entity")
        fun readFtn():List<Ftn_Entity>

        @Query("SELECT FTN_STEP FROM Ftn_Entity WHERE days = (SELECT MAX(days) FROM Ftn_Entity)")
        fun lastday():Int

    }

