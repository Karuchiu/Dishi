package com.kd.dishi.recipes.viewmodel

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kd.dishi.data.local.LocalRecipeProvider
import com.kd.dishi.models.Comment
import com.kd.dishi.models.Recipe
import com.kd.dishi.recipes.RecipeDestination
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class RecipeUiState(
    val id: Int = 0,
    val imageResId: Int = 0,
    val title: String = "",
    val comments: List<Comment>? = listOf()
)

class RecipeViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(RecipeUiState())
    val uiState = _uiState.asStateFlow()

    private val recipeId: Int = checkNotNull(savedStateHandle[RecipeDestination.recipeIdArg])

    init {
        initializeUIState()
    }

    private fun initializeUIState() {
        var recipe: Recipe = LocalRecipeProvider.recipeList[recipeId]

        _uiState.value = RecipeUiState(
            id = recipe.recipeId,
            imageResId = recipe.recipeImage,
            title = recipe.recipeName,
            comments = recipe.commentList
        )
    }
}