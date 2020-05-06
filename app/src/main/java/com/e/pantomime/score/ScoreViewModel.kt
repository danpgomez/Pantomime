package com.e.pantomime.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(finalScore: Int) : ViewModel() {
    private val _score = MutableLiveData<Int>()
    val score: LiveData<Int>
        get() = _score

    private val _eventPlayAgain =  MutableLiveData<Boolean>()
    val eventPlayAgain: LiveData<Boolean>
        get() = _eventPlayAgain


    init {
        _score.value = finalScore
        _eventPlayAgain.value = false
    }

    fun playAgainTapped() {
        _eventPlayAgain.value = true
    }

    fun eventPlayAgainComplete() {
        _eventPlayAgain.value = false
    }
}