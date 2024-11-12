package com.example.student_study_app

import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import com.example.student_study_app.API.RetrofitInstance
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.student_study_app.databinding.ActivityMainBinding
import kotlinx.coroutines.launch


class Leaderboards : AppCompatActivity() {
    private var listLeaderboard:ListView?=null
    private lateinit var binding: ActivityMainBinding
    private var adapter: ArrayAdapter<Any>?=null
    private var leaderboardArray: ArrayList<Any>?=null



    override fun onCreate(savedInstanceState: Bundle?) {

        lifecycleScope.launch {
            try {
                val response = RetrofitInstance.getLeaderboard() // API interface
                if (response.isSuccessful){ // This is an if stattment to check if a response is succesful
                    val repBody= response.body() // If there is a response body (JSON), you will added to the variable you specified
                    repBody?.let{
                        OBJECTLIST = repBody // varaible you specified
                    }
                }
            }
        }

        super.onCreate(savedInstanceState)
        listLeaderboard = findViewById(R.id.LeaderboardList)
        //val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, leaderboardArray)
       // setListAdapter(adapter)

    }


}