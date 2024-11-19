package com.jcb.chucknorris.presentation.utils

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import com.jcb.chucknorris.R

object BindingAdapters {
    @JvmStatic
    @BindingAdapter("imageUrl")
    fun loadImage(view: ImageView, url: String?) {
        view.load(url) {
            crossfade(true)
            placeholder(R.drawable.ic_launcher_foreground)
            error(R.drawable.ic_launcher_foreground)
        }
    }
}