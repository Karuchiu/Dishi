package com.kd.dishi.data.local

import com.kd.dishi.R
import com.kd.dishi.models.Recipe

object LocalRecipeProvider {
    val curator = LocalCuratorProvider
    val comment = LocalCommentProvider

    val fufu =
        Recipe(
        0,
       listOf(LocalCuratorProvider.karuchiu, LocalCuratorProvider.cobi),
        "Cassava flour and water",
        "Add the flour to a sufuria. Add cold water. Stir it a smooth-like mixture. Put it to heat. simmer.",
        R.drawable.fufu,
        "Fufu",
        commentList = listOf(/*comment.comment3, comment.comment5*/)
    )


    val veggies =
        Recipe(
        1,
            listOf(
                LocalCuratorProvider.karuchiu,
                LocalCuratorProvider.njogu,
                LocalCuratorProvider.cobi
            ),
        "Cucumber, carrot, tomatoes, mushrooms, onions",
        "Cut all these ingredients into small pieces and slices. Mix them. This is for vegetarians",
        R.drawable.veggies,
        "Veggies",
            listOf(/*comment.comment3*/)
    )


    val pilau = Recipe(
        2,
        listOf(LocalCuratorProvider.karuchiu),
        "Rice, meat, onions, cooking oil, water and salt",
        "Add cooking oil together with the onion in a sufuria an put them to heat. Until golden brown. Add meat to cook. Add water and salt appropriately. " +
                "Taste amount of sal (salt in spanish haha). Add rice. Wait for 10 minutes. Serve while hot",
        R.drawable.pilau,
        "Pilau",
       listOf(/*comment.comment5, comment.comment6, comment.comment7*/)
    )

    val recipeList = listOf(
        fufu, veggies, pilau
    )

}

