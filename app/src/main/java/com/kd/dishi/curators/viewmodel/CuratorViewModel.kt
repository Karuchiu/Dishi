package com.kd.dishi.curators.viewmodel

import android.util.Log
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.kd.dishi.curators.CuratorDestination
import com.kd.dishi.data.local.LocalCuratorProvider
import com.kd.dishi.models.Curator
import com.kd.dishi.models.Recipe
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

data class CuratorUiState(
    val id: Int = 0,
    val imageResId: Int = 0,
    val title: String = "",
    val recipes: List<Recipe>? = listOf(),
    val email: String = ""
)

/*fun CuratorUiState.toCurator(): Curator {
    val nameParts = title.split(" ")
    val firstName = nameParts.firstOrNull() ?: ""
    val lastName = nameParts.drop(1).joinToString(" ")

    return Curator(
        curatorId = id,
        email = email,
        curatorImage = imageResId,
        firstName = firstName,
        lastName = lastName,
        password = "",
        recipeList = recipes
    )
}*/

class CuratorViewModel(
    savedStateHandle: SavedStateHandle
) : ViewModel() {
    private val _uiState = MutableStateFlow(CuratorUiState())
    val uiState = _uiState.asStateFlow()

    private val curatorId: Int = checkNotNull(
        savedStateHandle[CuratorDestination.curatorIdArg]
    )

    init {
        initializeUiState()
    }

    private fun initializeUiState() {
        val curator = LocalCuratorProvider.curatorList[curatorId]

        Log.d("KW", "This : $curator")

        _uiState.value = CuratorUiState(
            id = curator.curatorId,
            imageResId = curator.curatorImage,
            title =  curator.firstName +" " + curator.lastName,
            recipes = curator.recipeList,
            email = curator.email
        )
    }
}

