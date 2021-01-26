package com.example.a65test

import android.annotation.SuppressLint
import android.app.ProgressDialog
import android.os.AsyncTask
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.a65test.FullSpisok.AsyncTaskHandler
import com.example.a65test.db.ListAdapter
import com.example.a65test.db.MyBbManager
import com.example.a65test.db.MyDataClass
import com.example.a65test.db.MySpecClass
import kotlinx.android.synthetic.main.fragment_full_spisok.*
import org.json.JSONObject
import java.net.HttpURLConnection
import java.net.URL

private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

class FullSpisok : Fragment() {

    val myDbManager = context?.let { MyBbManager(it) }

    lateinit var pDialog: ProgressDialog
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        val url = "https://gitlab.65apps.com/65gb/static/raw/master/testTask.json"
        AsyncTaskHandler().execute(url)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment

        val fullSpisok = inflater.inflate(R.layout.fragment_full_spisok, container, false)



        return fullSpisok
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment FullSpisok.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            FullSpisok().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }



    @SuppressLint("StaticFieldLeak")
    inner class AsyncTaskHandler : AsyncTask<String, String, String>() {
        override fun onPreExecute() {
            super.onPreExecute()
            pDialog = ProgressDialog(context)
            pDialog.setMessage("Wait")
            pDialog.setCancelable(false)
            pDialog.show()
        }

        override fun doInBackground(vararg url: String?): String {
            val res: String
            val connection = URL(url[0]).openConnection() as HttpURLConnection
            try {

                connection.connect()
                res = connection.inputStream.use { it.reader().use { reader -> reader.readText() } }
            } finally {

                connection.disconnect()
            }
            return res
        }

        @SuppressLint("SetTextI18n")
        override fun onPostExecute(response: String?) {
            super.onPostExecute(response)

            if (pDialog.isShowing)
                pDialog.dismiss()

            if (response != null) {


                val jsonResponse = JSONObject(response)
                val jsonArrayRes = jsonResponse.getJSONArray("response")
                val jsonArraySpec = jsonArrayRes.getJSONObject(0)

                val razmer = jsonArrayRes.length()
                val list = ArrayList<MyDataClass>()
                val listSpec = ArrayList<MySpecClass>()

                for (i in 0 until razmer ) {


                    val jsonInfo: JSONObject = jsonArrayRes.getJSONObject(i)
                    val mainList =    MyDataClass(
                        jsonInfo.getString("f_name"),
                        jsonInfo.getString("l_name"),
                        jsonInfo.getString("birthday"),
                        jsonInfo.getString("avatr_url"),
                        listSpec)
                    list.add(mainList)
                    myDbManager?.insertToBD(jsonInfo.getString("f_name"),jsonInfo.getString("l_name"),
                        jsonInfo.getString("birthday"),jsonInfo.getString("avatr_url"),
                        jsonInfo.getString("specialty_id"), jsonInfo.getString("name"))
                }

                val jsonArraySpeciality = jsonArraySpec.getJSONArray("specialty")
                val jsonSpec = jsonArraySpeciality.getJSONObject(0)
                if (jsonSpec != null){

                    for (j in 0 until  jsonArraySpeciality.length()) {
                        val jsonInfoSpec: JSONObject = jsonArraySpeciality.getJSONObject(j)

                        val otherList = MySpecClass(
                            jsonInfoSpec.getInt("specialty_id"),
                            jsonInfoSpec.getString("name")
                        )
                        listSpec.add(otherList)
                    }
                }

                //  if (f_name.text != null)

                val myAdapter = context?.let { ListAdapter(it, list) }


                lvMain.adapter = myAdapter

            }
        }
    }
}