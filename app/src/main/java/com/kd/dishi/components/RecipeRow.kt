package com.kd.dishi.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.R
import com.kd.dishi.models.Recipe

/*
    * TODO
    *  Material Theme
    *  White text on Dark mode not showing
    *
    * */

@Composable
fun RecipeRow(
    recipes: List<Recipe>,
    recipeOnClick: (Recipe) -> Unit = {}
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){

            items(recipes.size) { index ->
                RecipeCard(
                    recipe = recipes[index],
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
    Column {
        Row(
            modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.top_recipes),
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = modifier.weight(1f))
        }

        RecipeRow(
            recipes = recipeList,
            recipeOnClick = recipeOnClick
        )

    }
}