package com.kd.dishi.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kd.dishi.R
import com.kd.dishi.models.Recipe

@Composable
fun RecipeRow(
    recipes: List<Recipe>,
    recipeOnClick: (Recipe) -> Unit
) {
    RowItem(items = recipes, onItemClick = recipeOnClick) { recipe, onRecipeClick ->
        RecipeCard(recipe = recipe, recipeOnClick = onRecipeClick)
    }
}

@Composable
fun PopularRecipes(
    recipeList: List<Recipe>,
    modifier: Modifier = Modifier,
    recipeOnClick: (Recipe) -> Unit = {}
) {
    TitledList(
        items = recipeList,
        title = R.string.top_recipes,
        onItemClick = recipeOnClick,
        modifier = modifier
    ) { recipes, onItemClick ->
        RecipeRow(
            recipes = recipes,
            recipeOnClick = onItemClick
        )
    }
}