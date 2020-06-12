package com.example.fitnessapplication.fragments
import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.fitnessapplication.R
import com.example.fitnessapplication.room.App
import kotlinx.android.synthetic.main.fragment_home.*
import kotlinx.android.synthetic.main.fragment_stats.*

class StatisticFragment : Fragment(R.layout.fragment_stats) {


    private lateinit var navController: NavController



    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)



        var todaysinfo= App.instance.db.getftnDAO().lastday().toString()


        Daily_total_steps.text=todaysinfo








    }


}