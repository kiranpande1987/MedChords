package com.kprights.medchords.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kprights.medchords.R
import com.kprights.medchords.databinding.LayoutBodyBinding
import com.kprights.medchords.viewmodel.AppViewModel
import kotlinx.android.synthetic.main.fragment_home.view.*

class HomeFragment : Fragment() {

    private lateinit var homeViewModel: HomeViewModel

    override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
    ): View? {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_home, container, false)

        val binding = LayoutBodyBinding.bind(root.constBody)

        val appViewModel = AppViewModel()

        appViewModel.response.observe(viewLifecycleOwner,
            Observer { t -> Toast.makeText(activity, t, Toast.LENGTH_SHORT).show() })

        binding.viewModel = appViewModel

        return root
    }
}
