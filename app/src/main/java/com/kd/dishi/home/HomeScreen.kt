package com.kd.dishi.home

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Notifications
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.kd.dishi.R
import com.kd.dishi.components.COutlinedTextField
import com.kd.dishi.components.PopularCurators
import com.kd.dishi.components.PopularRecipes
import com.kd.dishi.home.viewmodel.HomeViewModel
import com.kd.dishi.navigation.NavigationDestination

object HomeDestination : NavigationDestination {
    override val route = "home"
    override val titleRes: Int = R.string.app_name
}

/*TODO
*  Prevent BackStackEntry to Login page or register page
* */

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    modifier: Modifier = Modifier,
    onCuratorClick: (Int) -> Unit,
    onRecipeClick: (Int) -> Unit,
    addRecipeClick: () -> Unit,
    viewModel: HomeViewModel = viewModel()
) {
    val homeUiState by viewModel.uiState.collectAsState()

    val focusManager = LocalFocusManager.current

    var recipeSearch by rememberSaveable {
        mutableStateOf("")
    }

    Scaffold(
        topBar = {
            /*DisheyTopAppBar(
                title = stringResource(id = HomeDestination.titleRes),
                canNavigateBack = false
            )*/
        },
        floatingActionButton = {
            FloatingActionButton(onClick = addRecipeClick) {
                Icon(Icons.Filled.Add, contentDescription = "Add Recipe")
            }
        }
    ) {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(top = 30.dp, bottom = 150.dp, start = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.SpaceEvenly
        ) {
            Column {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = stringResource(id = R.string.find_recipe),
                        style = MaterialTheme.typography.titleLarge
                    )
                    Spacer(modifier = Modifier.weight(1f))
                    Icon(
                        Icons.Outlined.Notifications,
                        contentDescription = null,
                        modifier = modifier
                            .size(40.dp)
                    )
                }

                Row(
                    modifier = modifier
                        .fillMaxWidth()
                ) {
                    COutlinedTextField(
                        value = recipeSearch,
                        onValueChange = { recipeSearch = it },
                        label = R.string.what_recipe,
                        icon = Icons.Default.Search,
                        iconDesc = "Search Recipe",
                        keyboardOptions = KeyboardOptions(
                            keyboardType = KeyboardType.Text,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { focusManager.clearFocus() }
                        ),
                        visualTransformation = VisualTransformation.None
                    )

                    Spacer(modifier = modifier.weight(1f))

                    Icon(
                        painter = painterResource(id = R.drawable.filter_icon),
                        contentDescription = null,
                        modifier = modifier
                            .size(40.dp)
                            .align(Alignment.CenterVertically)
                    )
                }
            }

            PopularCurators(curatorList = homeUiState.curatorList ){
                onCuratorClick(it.curatorId)
            }

            PopularRecipes(recipeList = homeUiState.popularRecipeList){
                onRecipeClick(it.recipeId)
            }

        }

    }
}
