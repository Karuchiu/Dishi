package com.kd.dishi.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.kd.dishi.R
import com.kd.dishi.models.Recipe

@Composable
fun RecipeRow(
    recipes: List<Recipe>,
    recipeOnClick: (Recipe) -> Unit = {}
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(recipes){
            RecipeCard(
                recipe = it,
                recipeOnClick = recipeOnClick
            )
        }
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