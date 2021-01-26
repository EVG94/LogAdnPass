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
import com.example.a65test.db.MyDataClass
import kotlinx.android.synthetic.main.fragment_spisok_rabotnikov.*
import java.time.LocalDate
import java.time.Period

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"


class SpisokRabotnikov : Fragment() {
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
        val managerFragment =
            inflater.inflate(R.layout.fragment_spisok_rabotnikov, container, false)

        val MyListManager: ArrayList<MyDataClass>

        val tv1: TextView = managerFragment.findViewById(R.id.vozrastIvan)
        val tv2: TextView = managerFragment.findViewById(R.id.vozrastPetr)
        val tv3: TextView = managerFragment.findViewById(R.id.vozrastVasya)
        val date1 = LocalDate.parse("1987-03-23")
        val date2 = LocalDate.parse("2021-01-23")
        val period = Period.between(date1, date2).years
        val date3 = LocalDate.parse("1985-11-29")
        val date4 = LocalDate.parse("2021-01-23")
        val period2 = Period.between(date3, date4).years



        tv1.text = "$period года"
        tv2.text = " - "
        tv3.text = "$period2 лет"

        val layout1: LinearLayout = managerFragment.findViewById(R.id.layout1)
        val layout2: LinearLayout = managerFragment.findViewById(R.id.layout2)
        val layout3: LinearLayout = managerFragment.findViewById(R.id.layout3)
        val navController = NavHostFragment.findNavController(this)

        layout1.setOnClickListener {
            navController.navigate(R.id.name1Fragment)
            Toast.makeText(context, " Info by Ivan ", Toast.LENGTH_SHORT).show()
        }
        layout2.setOnClickListener {
            navController.navigate(R.id.name2Fragment)
            Toast.makeText(context, " Info by Petr ", Toast.LENGTH_SHORT).show()
        }
        layout3.setOnClickListener {
            navController.navigate(R.id.name3Fragment)
            Toast.makeText(context, " Info by Vasiliy ", Toast.LENGTH_SHORT).show()
        }








        return managerFragment
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SpisokRabotnikov.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SpisokRabotnikov().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}