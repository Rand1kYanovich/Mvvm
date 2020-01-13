package com.example.testmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders

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