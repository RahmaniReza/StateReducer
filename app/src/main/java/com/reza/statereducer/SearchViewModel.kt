package com.reza.statereducer

import com.reza.statereducer.updateQuery
import com.reza.statereducer.updateFilters
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
        // USING KSP-GENERATED EXTENSION FUNCTION HERE!
        _uiState.value = _uiState.value.updateQuery { newQuery }
    }

    fun onToggleAvailability() {
        // USING KSP-GENERATED EXTENSION FUNCTION HERE!
        _uiState.value = _uiState.value.updateFilters { currentFilters ->
            currentFilters.copy(isAvailable = !currentFilters.isAvailable)
        }
    }
}