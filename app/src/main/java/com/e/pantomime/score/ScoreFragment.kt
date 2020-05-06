package com.e.pantomime.score

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs

import com.e.pantomime.R
import com.e.pantomime.databinding.FragmentScoreBinding

class ScoreFragment : Fragment() {

    private lateinit var binding: FragmentScoreBinding
    private lateinit var viewModel: ScoreViewModel
    private lateinit var viewModelFactory: ScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_score,
            container,
            false
        )

        val scoreFragmentArgs: ScoreFragmentArgs by navArgs<ScoreFragmentArgs>()
        viewModelFactory = ScoreViewModelFactory(scoreFragmentArgs.playerScore)
        viewModel = ViewModelProvider(this, viewModelFactory).get(ScoreViewModel::class.java)
        binding.scoreViewModel = viewModel
        setFinalScore()

        viewModel.eventPlayAgain.observe(viewLifecycleOwner, Observer { playAgainBtnTapped ->
            if (playAgainBtnTapped) {
                val action = ScoreFragmentDirections.actionScoreFragmentToGameFragment()
                findNavController().navigate(action)
                viewModel.eventPlayAgainComplete()
            }
        })

        return binding.root
    }

    private fun setFinalScore() {
        binding.finalScoreText.text = viewModel.score.value.toString()
    }
}
