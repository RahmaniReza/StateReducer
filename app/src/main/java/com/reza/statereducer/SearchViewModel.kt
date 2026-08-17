package com.reza.statereducer

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor() : ViewModel() {

    private val _uiState = MutableStateFlow(SearchUiState())
    val uiState: StateFlow<SearchUiState> = _uiState.asStateFlow()

    fun onQueryChanged(newQuery: String) {
        _uiState.value = _uiState.value.updateQuery(newQuery)
    }

    fun onToggleAvailability() {
        _uiState.value = _uiState.value.updateFilters {
            updateIsAvailable(!isAvailable)
        }
    }
}