package com.kd.dishi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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
    /*CardItem(
        imageURL = recipe.recipeImage,
        title = recipe.recipeName,
        onClick = { recipeOnClick(recipe) },
        modifier = modifier
    )*/
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