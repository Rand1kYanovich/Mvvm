package com.example.testmvvm.smartsport.ui.fragment.main.first

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.testmvvm.smartsport.entity.core.main.CustomObject
import com.example.testmvvm.R
import com.example.testmvvm.smartsport.ui.common.list.TestRVAdapter
import com.example.testmvvm.smartsport.ui.fragment.BaseFragment
import com.example.testmvvm.smartsport.viewmodel.test.TestViewModel
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.fragment_test.view.*

class TestFragment : BaseFragment() {
    override val layoutResId = R.layout.fragment_test

    private val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter =
            TestRVAdapter(
                arrayListOf(),
                requireContext()
            )
        view.recyclerView.adapter = adapter

        viewModel.text.observe(viewLifecycleOwner, Observer<CustomObject> {
            title.text = it.text
        })

        view.button.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_testSecondFragment)
        }
        viewModel.list.observe(viewLifecycleOwner, Observer<List<CustomObject>> {
            adapter.updateList(it)
        })
    }

}