package com.example.testmvvm

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_test.*
import kotlinx.android.synthetic.main.fragment_test.view.*

class TestFragment : Fragment() {

    private val viewModel: TestViewModel by lazy {
        ViewModelProviders.of(this).get(TestViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_test,container,false)

        view.recyclerView.layoutManager = LinearLayoutManager(requireContext())
        val adapter = TestRVAdapter(arrayListOf(),requireContext())
        view.recyclerView.adapter = adapter
        viewModel.getTitle().observe(viewLifecycleOwner,Observer<CustomObject>{
            title.text = it.text
        })

        viewModel.getList().observe(viewLifecycleOwner,Observer<List<CustomObject>>{
            adapter.updateList(it)
        })

        return view
    }

}