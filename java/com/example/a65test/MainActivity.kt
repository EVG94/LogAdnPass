package com.example.a65test

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.content.Context

import android.os.AsyncTask
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.view.GravityCompat
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.NavigationUI
import com.example.a65test.db.*


import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.row_layout.*
import kotlinx.android.synthetic.main.row_layout.view.*
import kotlinx.android.synthetic.main.row_speciality_layout.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {
    val myDbManager = MyBbManager(this)


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        imageMenu.setOnClickListener {
            drawer_layout.openDrawer(GravityCompat.START)
        }



        nav_view.itemIconTintList = null
        val navController = Navigation.findNavController(this, R.id.navFragment)
        NavigationUI.setupWithNavController(nav_view, navController)

        navController.addOnDestinationChangedListener(NavController.OnDestinationChangedListener { controller, destination, arguments ->

            tvTitle.text = destination.label
        })


    }

    override fun onResume() {
        super.onResume()
        myDbManager.openDB()


    }

    override fun onDestroy() {
        super.onDestroy()
        myDbManager.closeDB()

    }


}


