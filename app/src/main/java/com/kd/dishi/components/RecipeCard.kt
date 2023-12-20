package com.kd.dishi.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kd.dishi.models.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier,
    recipeOnClick: (Recipe) -> Unit
) {
    CardItem(
        imageURL = recipe.recipeImage,
        title = recipe.recipeName,
        onClick = { recipeOnClick(recipe) },
        modifier = modifier
    )
}