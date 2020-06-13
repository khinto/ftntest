package com.example.fitnessapplication.room
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Ftn_Entity(

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name="FTN_DAY")
    var ftn_day:Int?,
    @ColumnInfo(name = "FTN_STEP")
    var ftn_step: Int?,

    @ColumnInfo(name = "EMP_SLEEP")
    var ftn_sleep: Int,

    @ColumnInfo(name = "EMP_WEIGHT")
    var ftn_weight: Int?,


    @ColumnInfo(name = "FTN_KM")
    var ftn_km: Int?,

    @ColumnInfo(name = "FTN_CAL")

    var ftn_cal: Int?,

    @ColumnInfo(name = "FTN_SPEED")
    var ftn_speed: Int?,

    @ColumnInfo(name = "FTN_ACTIVETIME")
    var ftn_acttime: Int?


)