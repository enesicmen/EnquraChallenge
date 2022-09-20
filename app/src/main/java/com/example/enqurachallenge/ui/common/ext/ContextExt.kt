package com.example.enqurachallenge.ui.common.ext

import android.content.Context
import android.content.Intent
import android.net.Uri

fun Context?.openMap(address: String?){
    this?.let {
        if (address.isNullOrEmpty().not()){
            val url = "http://maps.google.co.in/maps?q=$address"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
            it.startActivity(intent)
        }
    }
}