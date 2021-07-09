package com.hasanaydin.newsagenda.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.hasanaydin.newsagenda.adapter.RecyclerViewAdapter
import com.hasanaydin.newsagenda.model.MainViewModel
import com.hasanaydin.newsagenda.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private var _binding : FragmentMainBinding? = null
    private val binding get() = _binding!!

    private lateinit var viewModel: MainViewModel

   lateinit var adapter : RecyclerViewAdapter


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)

        viewModel.loadData()

        _binding = FragmentMainBinding.inflate(inflater,container,false)
        val view = binding.root

        adapter = RecyclerViewAdapter(listOf())
        binding.recyclerView.adapter = adapter

        viewModel.liveData.observe(viewLifecycleOwner,{

            adapter.dataList = it.articles
            adapter.notifyDataSetChanged()

        })



        return view

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}