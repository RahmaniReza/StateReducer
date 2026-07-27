package com.reza.statereducer

import com.reza.reducer.annotations.GenerateUpdaters

@GenerateUpdaters
data class FilterOptions(
    val maxPrice: Int = 1000,
    val isAvailable: Boolean = false
)

@GenerateUpdaters
data class SearchUiState(
    val query: String = "",
    val isLoading: Boolean = false,
    val filters: FilterOptions = FilterOptions()
)