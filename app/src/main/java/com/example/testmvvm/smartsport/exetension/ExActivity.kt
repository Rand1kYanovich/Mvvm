package com.example.testmvvm.smartsport.exetension

import android.app.Activity
import androidx.core.view.isVisible
import kotlinx.android.synthetic.main.activity_main.*

fun Activity.showProgressBar(isShow:Boolean){
    this.progressBar.isVisible = isShow
}