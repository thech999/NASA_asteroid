package com.chgonzalez.nasaasteroid.detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import com.chgonzalez.nasaasteroid.R
import com.chgonzalez.nasaasteroid.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val binding = FragmentDetailBinding.inflate(inflater)
        binding.lifecycleOwner = this

        val asteroid = DetailFragmentArgs.fromBundle(requireArguments()).asteroidDetails

        val viewModelFactory = DetailViewModelFactory(asteroid)

        binding.asteroidDetailViewModel = ViewModelProvider(this, viewModelFactory).get(DetailViewModel::class.java)

        binding.helpButton.setOnClickListener {
            displayAstronomicalDialog()
        }

        return binding.root
    }

    private fun displayAstronomicalDialog() {
        val builder = AlertDialog.Builder(requireActivity())
                .setMessage(getString(R.string.astronomica_unit_explanation))
                .setPositiveButton(android.R.string.ok, null)
        builder.create().show()
    }

}