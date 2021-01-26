package com.example.a65test

import android.annotation.SuppressLint
import android.os.Build
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.navigation.fragment.NavHostFragment
import java.time.LocalDate
import java.time.Period

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SpisokRazrabotchikov.newInstance] factory method to
 * create an instance of this fragment.
 */
class SpisokRazrabotchikov : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    @SuppressLint("SetTextI18n")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val developersFragment =
            inflater.inflate(R.layout.fragment_spisok_razrabotchikov, container, false)

        val tv1: TextView = developersFragment.findViewById(R.id.vozrastVasyaDev)
        val tv2: TextView = developersFragment.findViewById(R.id.vozrastEkat)
        val tv3: TextView = developersFragment.findViewById(R.id.vozrastNikolay)
        val tv4: TextView = developersFragment.findViewById(R.id.vozrastViktor)
        val tv5: TextView = developersFragment.findViewById(R.id.vozrastArtur)
        val tv6: TextView = developersFragment.findViewById(R.id.vozrastArtur2)
        val tv7: TextView = developersFragment.findViewById(R.id.vozrastRus)
        val tv8: TextView = developersFragment.findViewById(R.id.vozrastVladimir)
        val date1 = LocalDate.parse("1985-11-29")
        val date2 = LocalDate.parse("2021-01-23")
        val period = Period.between(date1, date2).years
        tv1.text = "$period "

        val date3 = LocalDate.parse("1990-01-07")
        val date4 = LocalDate.parse("2021-01-23")
        val period2 = Period.between(date3, date4).years
        tv2.text = "$period2 "
        tv3.text = " - "

        val date5 = LocalDate.parse("2000-07-23")
        val date6 = LocalDate.parse("2021-01-23")
        val period3 = Period.between(date5, date6).years
        tv4.text = "$period3 "

        val date7 = LocalDate.parse("2000-07-23")
        val date8 = LocalDate.parse("2021-01-23")
        val period4 = Period.between(date7, date8).years
        tv5.text = "$period4 "

        val date9 = LocalDate.parse("1982-07-23")
        val date10 = LocalDate.parse("2021-01-23")
        val period5 = Period.between(date9, date10).years
        tv6.text = "$period5 "
        val date11 = LocalDate.parse("1984-10-17")
        val date12 = LocalDate.parse("2021-01-23")
        val period6 = Period.between(date11, date12).years
        tv7.text = "$period6 "
        val date13 = LocalDate.parse("1972-08-03")
        val date14 = LocalDate.parse("2021-01-23")
        val period7 = Period.between(date13, date14).years
        tv8.text = "$period7 "
        val layout1: LinearLayout = developersFragment.findViewById(R.id.layout1)
        val layout2: LinearLayout = developersFragment.findViewById(R.id.layout2)
        val layout3: LinearLayout = developersFragment.findViewById(R.id.layout3)
        val layout4: LinearLayout = developersFragment.findViewById(R.id.layout4)
        val layout5: LinearLayout = developersFragment.findViewById(R.id.layout5)
        val layout6: LinearLayout = developersFragment.findViewById(R.id.layout6)
        val layout7: LinearLayout = developersFragment.findViewById(R.id.layout7)
        val layout8: LinearLayout = developersFragment.findViewById(R.id.layout8)
        val navController = NavHostFragment.findNavController(this)

        layout1.setOnClickListener {
            navController.navigate(R.id.name4Fragment)
            Toast.makeText(context, " Info by Vasiliy ", Toast.LENGTH_SHORT).show()
        }
        layout2.setOnClickListener {
            navController.navigate(R.id.name5Fragment)
            Toast.makeText(context, " Info by Ekaterina ", Toast.LENGTH_SHORT).show()
        }
        layout3.setOnClickListener {
            navController.navigate(R.id.name6Fragment)
            Toast.makeText(context, " Info by Nikolay ", Toast.LENGTH_SHORT).show()
        }
        layout4.setOnClickListener {
            navController.navigate(R.id.name7Fragment)
            Toast.makeText(context, " Info by Viktor ", Toast.LENGTH_SHORT).show()
        }
        layout5.setOnClickListener {
            navController.navigate(R.id.name8Fragment)
            Toast.makeText(context, " Info by Artur ", Toast.LENGTH_SHORT).show()
        }
        layout6.setOnClickListener {
            navController.navigate(R.id.name9Fragment)
            Toast.makeText(context, " Info by Artur ", Toast.LENGTH_SHORT).show()
        }
        layout7.setOnClickListener {
            navController.navigate(R.id.name10Fragment)
            Toast.makeText(context, " Info by Ruslan ", Toast.LENGTH_SHORT).show()
        }
        layout8.setOnClickListener {
            navController.navigate(R.id.name11Fragment)
            Toast.makeText(context, " Info by Vladimir ", Toast.LENGTH_SHORT).show()
        }





        return developersFragment
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SpisokRazrabotchikov.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpisokRazrabotchikov().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}