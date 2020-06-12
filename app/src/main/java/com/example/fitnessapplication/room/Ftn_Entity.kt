package com.example.fitnessapplication.room
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Ftn_Entity

    (
    @PrimaryKey(autoGenerate = true)

    @ColumnInfo(name = "days")
    var day:Int,

    @ColumnInfo(name = "FTN_STEP")
    var ftn_step:Int?,

    @ColumnInfo(name = "EMP_SLEEP")
    var ftn_sleep:Int,


    @ColumnInfo(name = "EMP_WEIGHT")
    var ftn_weight:Int?





)