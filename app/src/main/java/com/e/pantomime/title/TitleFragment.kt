package com.e.pantomime.title

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.e.pantomime.R
import com.e.pantomime.databinding.FragmentTitleBinding
import com.e.pantomime.game.Category


class TitleFragment : Fragment() {
    private lateinit var viewModel: TitleViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentTitleBinding = DataBindingUtil.inflate(inflater, R.layout.fragment_title, container, false)
        viewModel = ViewModelProvider(this).get(TitleViewModel::class.java)
        binding.titleViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.category.observe(viewLifecycleOwner, Observer { category ->
            val action = TitleFragmentDirections.actionTitleFragmentToGameFragment(category)
            view?.findNavController()?.navigate(action)
        })

        return binding.root
    }

}
