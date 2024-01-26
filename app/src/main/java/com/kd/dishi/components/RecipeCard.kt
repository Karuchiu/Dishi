package com.kd.dishi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.models.Recipe

@Composable
fun RecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier,
    recipeOnClick: (Recipe) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .size(180.dp)
            .clickable { recipeOnClick(recipe) },
        elevation = CardDefaults.cardElevation(8.dp)
    ) {
        Column(
            modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = modifier.size(80.dp),
                painter = painterResource(id = recipe.recipeImage),
                contentDescription = null
            )
            Text(
                text =  recipe.recipeName,
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}