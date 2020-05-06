package com.e.pantomime.game

import android.os.Build
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.getSystemService
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.e.pantomime.R
import com.e.pantomime.databinding.FragmentGameBinding

class GameFragment : Fragment() {

    private lateinit var binding: FragmentGameBinding
    private lateinit var viewModel: GameViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(
            inflater,
            R.layout.fragment_game,
            container,
            false
        )

        viewModel = ViewModelProvider(this).get(GameViewModel::class.java)
        binding.gameViewModel = viewModel
        binding.lifecycleOwner = this

        viewModel.eventGameFinished.observe(viewLifecycleOwner, Observer { hasFinished ->
            if (hasFinished) {
                onGameFinished()
                viewModel.gameFinishedComplete()
            }
        })

        viewModel.buzzingType.observe(viewLifecycleOwner, Observer { buzzing ->
            if (buzzing != GameViewModel.BuzzType.NO_BUZZ) {
                buzz(buzzing.pattern)
                viewModel.onBuzzComplete()
            }
        })

        return binding.root
    }

    private fun onGameFinished() {
        val currentScore = viewModel.score.value ?: 0
        val action = GameFragmentDirections.actionGameFragmentToScoreFragment(currentScore)
        findNavController().navigate(action)
    }

    private fun buzz(buzzPattern: LongArray) {
        val buzzer = activity?.getSystemService<Vibrator>()
        buzzer?.let {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                buzzer.vibrate(VibrationEffect.createWaveform(buzzPattern, -1))
            } else {
                // This was deprecated in api 26
                buzzer.vibrate(buzzPattern, -1)
            }
        }
    }
}
