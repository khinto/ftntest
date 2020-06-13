package com.example.fitnessapplication.fragments
import android.annotation.SuppressLint
import com.example.fitnessapplication.room.App
import android.graphics.Color
import android.icu.text.DateFormat.DAY
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.fitnessapplication.R
import com.example.fitnessapplication.room.Ftn_Entity

import kotlinx.android.synthetic.main.fragment_stats.*
import kotlinx.android.synthetic.main.recycler_view_item.*
import kotlin.math.roundToInt

class StatisticFragment : Fragment(R.layout.fragment_stats) {


    private lateinit var navController: NavController



    @SuppressLint("SetTextI18n")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)



        var todaysinfo=
            App.instance.db.getftnDAO().lastday().toString()

        var lastinfoweight=
            App.instance.db.getftnDAO().lastdayweight().toString()

        var lastSleep=App.instance.db.getftnDAO().getsleep().toString()

        var getDays=App.instance.db.getftnDAO().getdays().toString()

        //MATH
        var StepstoKM= 0.762.times(todaysinfo.toInt())/1000

        var StepstokmROUND= (StepstoKM * 100).roundToInt() / 100.0

        // 95 % accuracy
        var kcalburned_approximately=
            StepstokmROUND.times(47*lastinfoweight.toInt()/73)

        var averagespeed=3.2.times(StepstokmROUND/3.83)

        var tH=StepstokmROUND/averagespeed

        var tMins=tH*60

        var tMins1= (tMins * 100).roundToInt() / 100.0



        //Only shows 100%
        var percentage = 100.times(todaysinfo.toInt()/9000)
        textView_per.text= "$percentage%"








        Thread {

            var km=StepstokmROUND.toInt()
            var cal=kcalburned_approximately.toInt()
            var speed=averagespeed.toInt()
            var activtime=tMins1.toInt()

            App.instance.db.getftnDAO(). insert(
                Ftn_Entity(
                    ftn_day = getDays.toInt(),
                    ftn_sleep = lastSleep.toInt(),
                    ftn_weight = lastinfoweight.toInt(),
                    ftn_step = todaysinfo.toInt(),

                    ftn_km = km,
                    ftn_cal = cal,
                    ftn_speed = speed,
                    ftn_acttime = activtime
                )
            )

            App.instance.db.getftnDAO().readFtn().forEach {
                Log.i("@newdata", "km:${km}")
                Log.i("@newdata", "cal:${cal}")
                Log.i("@newdata", "speed:${speed}")
                Log.i("@newdata", "activetime:${activtime}")
            }

            }.start()


        Daily_total_steps.text=todaysinfo
        text_km.text=StepstokmROUND.toString()
        textView12.text=kcalburned_approximately.toString()
        textView13.text=tMins.toString()







        progress_circular.apply {
            setProgressWithAnimation(todaysinfo.toFloat(), 1000)
            progressMax = 9000f
        }

        progress_circular.onProgressChangeListener = { progressMax ->
           // notification.text = "congrats you reach your goal!"
            Daily_total_steps.setTextColor(Color.parseColor("#7CFC00"))
        }



        textView12.setTextColor(Color.parseColor("#000000"))

        Daily_total_steps.setTextColor(Color.parseColor("#000000"))


        if(tMins > 59  ){
            textView13.setTextColor(Color.parseColor("#7CFC00"))
        } else {
            textView13.setTextColor(Color.parseColor("#000000"))
        }



        if(StepstokmROUND > 6.85 ){
            text_km.setTextColor(Color.parseColor("#7CFC00"))
        }else{
            text_km.setTextColor(Color.parseColor("#000000"))
        }




        var AvgSteps=
            App.instance.db.getftnDAO().getAvgSteps().toString()

        var AVGKM=
            App.instance.db.getftnDAO().getAvgkm().toString()

        var AVGCal=App.instance.db.getftnDAO().getAvgCalories().toString()

        var AVGactive=App.instance.db.getftnDAO().getAvgacttime().toString()

        var AVGspeed=App.instance.db.getftnDAO().getAvgspeed().toString()

        var AVGweight=App.instance.db.getftnDAO().getAvgWeight().toString()


        textView16.text=AvgSteps
        textView18.text=AVGKM
        textView20.text=AVGweight
        textView22.text=AVGCal
        textView24.text=AVGactive
        textView26.text=AVGspeed











    }


}