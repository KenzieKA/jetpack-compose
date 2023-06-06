package kenz.jetpacktumblr.ui.screen.detail

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kenz.jetpacktumblr.model.Tumblr
import kenz.jetpacktumblr.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class DetailTumblrViewModel(
    private val repository: TumblrRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<Tumblr>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<Tumblr>>
        get() = _uiState

    fun getTumblrById(rewardId: Long) {
        viewModelScope.launch {
            _uiState.value = UiState.Loading
            _uiState.value = UiState.Success(repository.getTumblrById(rewardId))
        }
    }
}