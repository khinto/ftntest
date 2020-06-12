package com.example.fitnessapplication.fragments

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.Navigation
import com.example.fitnessapplication.R
import com.example.fitnessapplication.room.App
import com.example.fitnessapplication.room.Ftn_Entity
import kotlinx.android.synthetic.main.fragment_home.*
import java.lang.Integer.toString
import java.util.Arrays.toString

class HomeFragment : Fragment(R.layout.fragment_home) {
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        navController = Navigation.findNavController(view)



         button_submit.setOnClickListener {


            var DAY = editText_day.text.toString().toInt()
            var steps = edit_steps.text.toString().toInt()
            var sleep = edit_sleep.text.toString().toInt()
            var weight = edit_weight.text.toString().toInt()



            var data = Ftn_Entity(DAY,steps, sleep, weight)



            App.instance.db.getftnDAO().insert(data)



            App.instance.db.getftnDAO().readFtn().forEach {
                Log.i("@newdata", "Day:${DAY}")
                Log.i("@newdata", "Steps:${steps}")
                Log.i("@newdata", "Sleep:${sleep}")
                Log.i("@newdata", "Weight:${weight}")


            }



        }
    }
}


