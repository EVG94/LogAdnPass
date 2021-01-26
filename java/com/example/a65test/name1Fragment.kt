package com.example.a65test

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.a65test.db.ListAdapter
import com.example.a65test.db.MyDataClass
import com.example.a65test.db.MySpecClass
import kotlinx.android.synthetic.main.fragment_full_spisok.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [name1Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class name1Fragment : Fragment() {
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
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        val name1 = inflater.inflate(R.layout.fragment_name1, container, false)

        val tv1:TextView = name1.findViewById(R.id.f_name)
        tv1.text = "Имя: Иван"
        val tv2:TextView = name1.findViewById(R.id.l_name)
        tv2.text = "Фамилия : Иванов"
        val tv3:TextView = name1.findViewById(R.id.birthday)
        tv3.text = "Дата рождения: 1987-03-23"
        val tv4:TextView = name1.findViewById(R.id.age)
        tv4.text = "Возраст: 33"
        val tv5:TextView = name1.findViewById(R.id.spec)
        tv5.text = "Специальность: Менеджер"








        return name1
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment name1Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            name1Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

}