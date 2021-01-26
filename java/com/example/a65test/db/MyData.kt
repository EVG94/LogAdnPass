package com.example.a65test.db

data class MyDataClass(
    var f_name:String,
    var l_name:String,
    var birthday: String,
    var avatr_url:String,
    val listSpec:ArrayList<MySpecClass>



)

data class MySpecClass(
    val specialty_id: Int,
    val name_spec:String
)