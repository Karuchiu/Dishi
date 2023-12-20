package com.kd.dishi.models

import androidx.annotation.DrawableRes

data class Recipe(
    val recipeId: Int,
    val curator: List<Curator>,
    val ingredients: String,
    val directions: String,
    @DrawableRes val recipeImage: Int,
    val recipeName: String,
    val commentList: List<Comment>?
)
