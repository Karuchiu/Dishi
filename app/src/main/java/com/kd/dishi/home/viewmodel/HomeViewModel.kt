package com.kd.dishi.home.viewmodel

import android.util.Log
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
        val recipeList: List<Recipe> = LocalRecipeProvider.recipeList
        val curatorList: List<Curator> = LocalCuratorProvider.curatorList

        if (curatorList.isNotEmpty() && recipeList.isNotEmpty()) {
            //Log.d("KW", "Test : ${curatorList[0].firstName}")
            //Log.d("KW", "TestR : ${curatorList[0].recipeList}")

            _uiState.value = HomeUiState(
                curatorList = curatorList,
                popularRecipeList = recipeList
            )
        } else {
            // Handle case where lists are empty, perhaps set default values or show an error
            // For example:
            _uiState.value = HomeUiState() // Set default state
            // Or show an error message to indicate empty data
        }
    }
}


data class HomeUiState(
    val curatorList: List<Curator> = listOf(),
    val popularRecipeList: List<Recipe> = listOf()
)