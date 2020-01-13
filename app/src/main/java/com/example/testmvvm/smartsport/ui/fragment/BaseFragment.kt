package com.example.testmvvm.smartsport.ui.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.testmvvm.smartsport.exetension.showProgressBar

abstract class BaseFragment :Fragment() {

    abstract val layoutResId: Int?

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return layoutResId?.let { inflater.inflate(it,container,false) }
    }
    fun onShowProgress(isShow:Boolean){
        requireActivity().showProgressBar(isShow)
    }
}