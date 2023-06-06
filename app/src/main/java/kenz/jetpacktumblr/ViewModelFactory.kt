package kenz.jetpacktumblr

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kenz.jetpacktumblr.ui.screen.detail.DetailTumblrViewModel
import kenz.jetpacktumblr.ui.screen.home.HomeViewModel

class ViewModelFactory(private val repository: TumblrRepository) :
    ViewModelProvider.NewInstanceFactory() {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(HomeViewModel::class.java)) {
            return HomeViewModel(repository) as T
        } else if (modelClass.isAssignableFrom(DetailTumblrViewModel::class.java)) {
            return DetailTumblrViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
    }
}