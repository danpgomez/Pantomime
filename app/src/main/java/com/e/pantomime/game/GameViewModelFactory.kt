package com.e.pantomime.game

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import java.lang.IllegalArgumentException

class GameViewModelFactory(private val category: Category) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(GameViewModel::class.java)) {
            Log.i("GameViewModelFactory", "Category passed is: $category")
            return GameViewModel(category) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}