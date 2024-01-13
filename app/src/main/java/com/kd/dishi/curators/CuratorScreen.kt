package com.kd.dishi.curators

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.navigation.NavigationDestination
import com.kd.dishi.R
import com.kd.dishi.curators.viewmodel.CuratorViewModel
import androidx.lifecycle.viewmodel.compose.*
import com.kd.dishi.AppVMProvider
import com.kd.dishi.components.CDivider
import com.kd.dishi.components.RecipeRow

object CuratorDestination : NavigationDestination {
    override val route: String
        get() = "curator_screen"
    override val titleRes: Int
        get() = R.string.curator_profile
    const val curatorIdArg = "curatorId"
    val routeWithArgs
        get() = "$route/{$curatorIdArg}"
}

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun CuratorScreen(
    modifier: Modifier = Modifier,
    onRecipeClick: (Int) -> Unit = {},
    viewModel: CuratorViewModel = viewModel(factory = AppVMProvider.Factory),
    navigateBack: () -> Unit
) {
    val curatorUiState by viewModel.uiState.collectAsState()

    Scaffold(
        topBar = {
            /*DisheyTopAppBar(
                title = stringResource(id = CuratorScreenDestination.titleRes),
                canNavigateBack = true,
                navigateUp = navigateBack
            )*/
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 30.dp, bottom = 150.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                modifier = Modifier
                    .fillMaxHeight(0.5f)
                    .fillMaxWidth()
                    .padding(40.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.SpaceEvenly
            ) {
                Image(
                    modifier = Modifier
                        .size(150.dp)
                        .clip(RoundedCornerShape(50))
                        .border(2.dp, color = Color.Cyan, CircleShape),
                    painter = painterResource(id = curatorUiState.imageResId),
                    contentDescription = null,
                    contentScale = ContentScale.Crop
                )
                Text(
                    text = curatorUiState.title,
                    style = MaterialTheme.typography.labelLarge
                )

                Text(
                    text = stringResource(id =R.string.noOfRecipes, curatorUiState.recipes!!.size),
                    style = MaterialTheme.typography.titleLarge
                )

                CDivider()

                Text(
                    text = stringResource(id = R.string.my_recipes),
                    style = MaterialTheme.typography.labelMedium
                )

                RecipeRow(
                    recipes = curatorUiState.recipes ?: emptyList()
                ) { onRecipeClick(it.recipeId) }

            }
        }
    }
}