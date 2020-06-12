package com.example.fitnessapplication.fragments
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.fitnessapplication.R
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_stats.*

class StatisticFragment : Fragment(R.layout.fragment_stats) {

    val todaystep=edit_sleep.text.toString().toInt()
    val StepstoKM= 1312.34.toDouble()/todaystep
    val caloriesburn= 55 * StepstoKM




    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)















        progress_circular.apply {
            setProgressWithAnimation(65f, 1000)
            progressMax = 1200f
        }






    }


}