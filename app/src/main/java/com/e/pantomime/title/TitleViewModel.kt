package com.e.pantomime.title

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.e.pantomime.R
import com.e.pantomime.game.Category

class TitleViewModel : ViewModel() {
    private val _category = MutableLiveData<Category>()
    val category: LiveData<Category>
        get() = _category

    fun setCategory(buttonId: Int) {
        when(buttonId) {
            R.id.animals_category_button -> _category.value = Category.ANIMALS
            R.id.people_category_button -> _category.value = Category.PEOPLE
            R.id.movies_category_button -> _category.value = Category.MOVIES
        }
    }
}