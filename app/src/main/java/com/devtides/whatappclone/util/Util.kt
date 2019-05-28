package com.devtides.whatappclone.util

import android.content.Context
import android.support.v4.widget.CircularProgressDrawable
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.devtides.whatappclone.R
import java.text.DateFormat
import java.util.*

fun populateImage(context: Context?, uri: String?, imageView: ImageView, errorDrawable: Int = R.drawable.empty) {
    if(context != null) {
        val options = RequestOptions()
            .placeholder(progressDrawable(context))
            .error(errorDrawable)
        Glide.with(context)
            .load(uri)
            .apply(options)
            .into(imageView)
    }
}

fun progressDrawable(context: Context): CircularProgressDrawable {
    return CircularProgressDrawable(context).apply {
        strokeWidth = 5f
        centerRadius = 30f
        start()
    }
}

fun getTime(): String {
    val df = DateFormat.getDateInstance()
    return df.format(Date())
}