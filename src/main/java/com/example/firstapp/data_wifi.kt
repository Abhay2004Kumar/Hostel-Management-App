package com.example.firstapp

import android.media.Image

data class data_wifi(val Roll_number: String? = null,
    val Complain_description:String? = null,val Place:String? = null, val Date_of_complaint:String? = null, val Time_of_complaint: String? = null,
                     val Contact_no : String?=null, val img: Image?= null)
