package com.vmmarinc.sweetanikca2.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.bumptech.glide.Glide
import com.vmmarinc.sweetanikca2.databinding.FragmentHomeBinding
import com.vmmarinc.sweetanikca2.ui.viewmodels.HomeViewModel

import org.koin.android.ext.android.bind
import org.koin.android.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    private val binding get() = _binding!!

    private val homeViewModel: HomeViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_home, container, false)
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onStart() {
        super.onStart()
        homeViewModel.loadInfo()
        homeViewModel.info.observe(this, Observer { info ->
            binding.homeTitle.text = info.name
            binding.homeAddres.text = info.address
            binding.homeDescription.text = info.description
            //binding.homeImage = R.drawable.logo
            //Glide.with(binding.root).load(info.image).into(binding.homeImage)
        })
    }


}