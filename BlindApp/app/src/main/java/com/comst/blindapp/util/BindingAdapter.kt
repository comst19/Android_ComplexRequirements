package com.comst.blindapp.util

import android.widget.TextView
import androidx.databinding.BindingAdapter
import java.util.Date

@BindingAdapter("data")
fun TextView.setDate(date : Date?){
    text = DateUtil.convertPrintDateString(date)
}