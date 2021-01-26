package com.example.a65test

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [name10Fragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class name10Fragment : Fragment() {
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
        val name4 = inflater.inflate(R.layout.fragment_name10, container, false)
        val tv1: TextView = name4.findViewById(R.id.f_name)
        tv1.text = "Имя: Руслан"
        val tv2: TextView = name4.findViewById(R.id.l_name)
        tv2.text = "Фамилия : Русланов"
        val tv3: TextView = name4.findViewById(R.id.birthday)
        tv3.text = "Дата рождения: 17-10-1984 "
        val tv4: TextView = name4.findViewById(R.id.age)
        tv4.text = "Возраст: 36"
        val tv5: TextView = name4.findViewById(R.id.spec)
        tv5.text = "Специальность: Разработчик"
        return name4
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment name10Fragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            name10Fragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}