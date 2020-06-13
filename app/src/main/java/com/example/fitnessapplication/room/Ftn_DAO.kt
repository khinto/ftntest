package com.example.fitnessapplication.room

import androidx.room.*


@Dao
interface Ftn_DAO

    {


        @Insert(onConflict = OnConflictStrategy.REPLACE)
        fun insert(vararg ftn: Ftn_Entity)

        @Query("select * from Ftn_Entity")
        fun readFtn():List<Ftn_Entity>

        @Query("SELECT FTN_STEP FROM Ftn_Entity WHERE ftn_day = (SELECT MAX(ftn_day) FROM Ftn_Entity)")

        fun lastday():Int

        @Query("SELECT EMP_WEIGHT FROM Ftn_Entity WHERE ftn_day = (SELECT MAX(ftn_day) FROM Ftn_Entity)")
        fun lastdayweight():Int

        @Query("SELECT EMP_SLEEP FROM Ftn_Entity WHERE ftn_day = (SELECT MAX(ftn_day) FROM Ftn_Entity)")
        fun getsleep():Int

        @Query("SELECT EMP_WEIGHT FROM Ftn_Entity WHERE ftn_day = (SELECT MAX(ftn_day) FROM Ftn_Entity)")
        fun getweight():Int
        @Query("SELECT FTN_DAY FROM Ftn_Entity WHERE ftn_day = (SELECT MAX(ftn_day) FROM Ftn_Entity)")
        fun getdays():Int

        @Query("SELECT AVG(FTN_STEP) FROM Ftn_Entity")
        fun getAvgSteps(): Int


        @Query("SELECT AVG(EMP_SLEEP) FROM Ftn_Entity")
        fun getAvgHours(): Int


        @Query("SELECT AVG(FTN_KM) FROM Ftn_Entity")
        fun getAvgkm(): Int

        @Query("SELECT AVG(FTN_CAL) FROM Ftn_Entity")
        fun getAvgCalories(): Int

        @Query("SELECT AVG(EMP_WEIGHT) FROM Ftn_Entity")
        fun getAvgWeight(): Int

        @Query("SELECT AVG(FTN_SPEED) FROM Ftn_Entity")
        fun getAvgspeed(): Int

        @Query("SELECT AVG(FTN_ACTIVETIME) FROM Ftn_Entity")
        fun getAvgacttime(): Int








    }

