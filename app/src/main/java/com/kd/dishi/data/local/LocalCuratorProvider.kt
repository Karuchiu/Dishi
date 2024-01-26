package com.kd.dishi.data.local

import com.kd.dishi.R
import com.kd.dishi.models.Curator

object LocalCuratorProvider {
    val recipe = LocalRecipeProvider

    val karuchiu: Curator =
        Curator(
            0,
            "karuchiu@gmail.com",
            R.drawable.benz_dp,
            "Karuchiu",
            "Don",
            recipeList = listOf(recipe.fufu, recipe.veggies, recipe.pilau),
            "12345678"
        )


    val njogu: Curator =
        Curator(
            1,
            "njogu@gmail.com",
            R.drawable.tabata,
            "Dan",
            "Njogu",
            recipeList = listOf(recipe.veggies),
            "njogu123"
        )

    val cobi: Curator =
        Curator(
            2,
            "cobi@gmail.com",
            R.drawable.karibu_kanairo,
            "Mbutu",
            "Don",
            recipeList = listOf(recipe.fufu, recipe.veggies),
            "trippl3m"
        )

    val east: Curator =
        Curator(
            3,
            "east@gmail.com",
            R.drawable.iten,
            "Lofty",
            "Rugby",
            recipeList = listOf(),
            "east1234"
        )

    val curatorList = listOf(
        karuchiu, njogu, cobi, east
    )
}

