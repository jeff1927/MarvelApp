package com.apps.marvelapp.domain.utils

import android.view.View
import android.widget.ProgressBar


fun ProgressBar.showProgressBar(){
    this.visibility = View.VISIBLE
}

fun ProgressBar.hideProgressBar(){
    this.visibility = View.GONE
}


