package com.example.fruitmvvmapp.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModelProvider
import com.example.fruitmvvmapp.R
import com.example.fruitmvvmapp.databinding.FragmentFruitsBinding
import com.example.fruitmvvmapp.viewmodel.FruitViewModel

class FruitsFragment : Fragment() {

    private lateinit var binding: FragmentFruitsBinding

    private val viewModel : FruitViewModel by viewModels()

    private val koinViewModelInjected: FruitViewModel by viewModels()

    private lateinit var fruitsViewModel: FruitViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        fruitsViewModel = ViewModelProvider(this, defaultViewModelProviderFactory).get(FruitViewModel::class.java)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fruits, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() = FruitsFragment()
    }
}