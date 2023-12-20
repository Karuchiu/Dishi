package com.kd.dishi.home.viewmodel

import androidx.lifecycle.ViewModel
import com.kd.dishi.data.local.LocalCuratorProvider
import com.kd.dishi.data.local.LocalRecipeProvider
import com.kd.dishi.models.Curator
import com.kd.dishi.models.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel: ViewModel() {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        val recipeList: List<Recipe> =
            LocalRecipeProvider.recipeList
        val curatorList: List<Curator> =
            LocalCuratorProvider.curatorList
        _uiState.value =
            HomeUiState(
                curatorList = curatorList,
                popularRecipeList = recipeList
            )
    }
}

data class HomeUiState(
    val curatorList: List<Curator> = listOf(),
    val popularRecipeList: List<Recipe> = listOf()
)