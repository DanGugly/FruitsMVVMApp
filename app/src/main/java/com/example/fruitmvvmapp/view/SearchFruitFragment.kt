package com.example.fruitmvvmapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.fruitmvvmapp.R
import com.example.fruitmvvmapp.databinding.FragmentFruitsBinding
import com.example.fruitmvvmapp.utils.ResponseState
import com.example.fruitmvvmapp.viewmodel.FruitViewModel


class SearchFruitFragment : Fragment() {
    private lateinit var binding: FragmentFruitsBinding
    /**
     * Here we are providing the viewmodel
     */
    private val viewModel: FruitViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentFruitsBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        viewModel.searchFruit.observe(viewLifecycleOwner) { uiState ->
            when(uiState.state){
                ResponseState.LOADING -> {
                    //Show loading spinner
                }
                ResponseState.SUCCESS -> {
                    //Navigate to next fragment
                }
                ResponseState.ERROR -> {
                    //Display error to the user e.g invalid fruit
                }
            }
        }

        return binding.root
    }

    companion object {
        @JvmStatic
        fun newInstance() = SearchFruitFragment()
    }
}