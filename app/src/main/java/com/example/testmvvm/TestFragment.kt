package com.example.testmvvm

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.fragment_test.view.*

class TestFragment : BaseFragment() {
    override val layoutResId = R.layout.fragment_test

    private val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    //проверить переживает ли поворот активити viemodel
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TestRVAdapter(arrayListOf(), requireContext())
        view.recyclerView.adapter = adapter

        viewModel.getTitle().observe(viewLifecycleOwner, Observer<CustomObject> {
            title.text = it.text
        })

        view.button.setOnClickListener {
            findNavController().navigate(R.id.action_testFragment_to_testSecondFragment)
        }

        //посмотреть примеры
        viewModel.getList().observe(viewLifecycleOwner, Observer<List<CustomObject>> {
            adapter.updateList(it)
        })
    }

}