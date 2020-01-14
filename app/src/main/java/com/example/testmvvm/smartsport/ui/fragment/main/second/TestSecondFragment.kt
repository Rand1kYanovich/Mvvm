package com.example.testmvvm.smartsport.ui.fragment.main.second

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.bumptech.glide.Glide
import com.example.testmvvm.R
import com.example.testmvvm.smartsport.ui.fragment.BaseFragment
import com.example.testmvvm.smartsport.viewmodel.secondtest.SecondTestViewModel
import kotlinx.android.synthetic.main.second_fragment.*

class TestSecondFragment : BaseFragment() {

    private val viewModel: SecondTestViewModel by lazy {
        ViewModelProviders.of(this).get(SecondTestViewModel::class.java)
    }
    override val layoutResId = R.layout.second_fragment

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.timonString.observe(viewLifecycleOwner, Observer<String> {
            tvTimon.text = it
        })

    }
}