package com.uygemre.nesine.extensions

import android.widget.ImageView
import com.bumptech.glide.Glide

fun ImageView.loadImage(url: String) {
    Glide.with(this.context).load(url).centerInside().into(this)
}