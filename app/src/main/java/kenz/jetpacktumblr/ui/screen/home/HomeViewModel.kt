package kenz.jetpacktumblr.ui.screen.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kenz.jetpacktumblr.model.Tumblr
import kenz.jetpacktumblr.ui.common.UiState
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class HomeViewModel(
    private val repository: TumblrRepository
) : ViewModel() {
    private val _uiState: MutableStateFlow<UiState<List<Tumblr>>> = MutableStateFlow(UiState.Loading)
    val uiState: StateFlow<UiState<List<Tumblr>>>
        get() = _uiState

    fun getAllTumblr() {
        viewModelScope.launch {
            repository.getAllRewards()
                .catch {
                    _uiState.value = UiState.Error(it.message.toString())
                }
                .collect { tumblr ->
                    _uiState.value = UiState.Success(tumblr)
                }
        }
    }
}