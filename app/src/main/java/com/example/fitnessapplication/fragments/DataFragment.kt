package com.example.fitnessapplication.fragments

import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.room.Room
import com.example.fitnessapplication.R
import com.example.fitnessapplication.recyclerview.adapter.FitnessAdapter
import com.example.fitnessapplication.room.App
import kotlinx.android.synthetic.main.fragment_data.*


class DataFragment : Fragment(R.layout.fragment_data) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

       var allthedata= App.instance.db.getftnDAO().readFtn()

        val adapter = FitnessAdapter(allthedata)


        recyclerView.layoutManager=LinearLayoutManager(this.context)
        recyclerView.adapter=adapter



    }
}