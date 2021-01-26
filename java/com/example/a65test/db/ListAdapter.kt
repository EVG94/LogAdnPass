package com.example.a65test.db

import android.annotation.SuppressLint
import android.content.Context
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import com.example.a65test.R
import com.squareup.picasso.Picasso
import java.lang.Exception
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.*
import kotlin.collections.ArrayList

class ListAdapter(private val context: Context, private val list: ArrayList<MyDataClass>) :
    BaseAdapter() {
    val myDbManager = MyBbManager(context)

    override fun getCount(): Int {
        return list.size

    }

    override fun getItem(position: Int): Any {
        return position

    }

    override fun getItemId(position: Int): Long {
        return position.toLong()

    }

    @RequiresApi(Build.VERSION_CODES.O)
    @Suppress("DEPRECATION")
    @SuppressLint("ViewHolder", "UnsafeDynamicallyLoadedCode", "SimpleDateFormat", "SetTextI18n")

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {


        val view: View = LayoutInflater.from(context).inflate(R.layout.row_layout, parent, false)
        val fName = view.findViewById<TextView>(R.id.f_name)
        val lName = view.findViewById<TextView>(R.id.l_name)
        val birthday = view.findViewById<TextView>(R.id.birthday)
        val avatar = view.findViewById<TextView>(R.id.avatar)
        val imgWeb = view.findViewById<ImageView>(R.id.imgWEB)
        val linear = view.findViewById<LinearLayout>(R.id.SpecNameId)

        linear.removeAllViews()
        fName.text = list[position].f_name
        lName.text = list[position].l_name
        birthday.text = list[position].birthday
        avatar.text = list[position].avatr_url

        list[position].listSpec.forEach { perem ->
            val mySpisok: View =
                LayoutInflater.from(context).inflate(R.layout.row_speciality_layout, parent, false)
          val idSpeciality = mySpisok.findViewById<TextView>(R.id.idSpeciality)
            val nameSpeciality = mySpisok.findViewById<TextView>(R.id.nameSpeciality)


            idSpeciality.text = perem.specialty_id.toString()
            val idString:String = idSpeciality.text.toString()
            nameSpeciality.text = perem.name_spec

            linear.addView(mySpisok)

            myDbManager.insertToBD(fName.text.toString(),lName.text.toString(),birthday.text.toString(),avatar.text.toString(),idString, nameSpeciality.text.toString())
        }



        val imageUrl: String = avatar.text.toString()
        val date: String = birthday.text.toString()
        //proverki
        val strArrayOBJ =
            fName.text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val builder = StringBuilder()
        for (s in strArrayOBJ) {
            val cap = s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1)
            builder.append("$cap ")
        }
        fName.text = builder.toString()
        val strArrayOBJFam =
            lName.text.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        val builderFam = StringBuilder()
        for (s in strArrayOBJFam) {
            val cap = s.substring(0, 1).toUpperCase(Locale.ROOT) + s.substring(1)
            builderFam.append("$cap ")
        }
        lName.text = builderFam.toString()

        //proverka date

        if (imageUrl != "null" && imageUrl != "") {
            Picasso.get().load(imageUrl).error(R.drawable.avatarka).into(imgWeb)
        } else {
            Picasso.get().load(R.drawable.avatarka).error(R.drawable.avatarka).into(imgWeb)
        }

        //исключения для даты
        try {
            if (date == "null" || date == "") {
                birthday.text = "-"

            } else {
                val formatter2 = DateTimeFormatter.ofPattern("yyyy-MM-dd")
                val date1 = LocalDate.parse(date, formatter2)
                val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
                val date2 = date1.format(formatter)
                birthday.text = "$date2 г."
            }


        } catch (e: Exception) {
            val formatter3 = DateTimeFormatter.ofPattern("dd-MM-yyyy")
            val dateP = LocalDate.parse(date, formatter3)
            val formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy")
            val date2 = dateP.format(formatter)
            birthday.text = "$date2 г."
        }


        return view
    }
}