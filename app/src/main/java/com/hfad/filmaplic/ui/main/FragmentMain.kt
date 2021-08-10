package com.hfad.filmaplic.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.android.material.snackbar.Snackbar
import com.hfad.filmaplic.com.hfad.filmaplic.ui.main.MainAdapter
import com.hfad.filmaplic.databinding.FragmentMainBinding


class FragmentMain : Fragment() {

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!
    lateinit var viewModel: MainViewModel
    private var adapter = MainAdapter()

    companion object {
        fun newInstance() = FragmentMain()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentMainBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
       binding.recycleViewContainer.adapter = adapter
        viewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.getData().observe(viewLifecycleOwner, Observer { renewal(it) })
        viewModel.getFilms()
    }

    private fun renewal(appState: AppState) {
        when(appState){
            is AppState.SuccessList -> {
                binding.loadingLayout.visibility = View.GONE
                Snackbar.make(binding.loadingLayout,"Success OK", Snackbar.LENGTH_LONG).show()
                setData(appState.filmListArray)
                adapter.setFilms(appState.filmListArray)
            }
            is AppState.Loading -> {
                binding.loadingLayout.visibility = View.VISIBLE
            }
        }
    }

    private fun setData(filmList: List<Film>) {
        binding.name.text = filmList.size.toString()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}