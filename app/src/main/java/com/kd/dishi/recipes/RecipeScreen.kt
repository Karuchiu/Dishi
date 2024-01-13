package com.kd.dishi.recipes

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.BackdropScaffold
import androidx.compose.material.BackdropValue
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.Icon
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.rememberBackdropScaffoldState
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.*
import com.kd.dishi.AppVMProvider
import com.kd.dishi.R
import com.kd.dishi.components.CommentSection
import com.kd.dishi.components.DirectionsArea
import com.kd.dishi.components.IngredientsArea
import com.kd.dishi.navigation.NavigationDestination
import com.kd.dishi.recipes.viewmodel.RecipeViewModel

object RecipeDestination: NavigationDestination {
    override val route = "recipe_screen"
    override val titleRes: Int = R.string.this_recipe
    const val recipeIdArg = "recipeId"
    val routeWithArgs = "$route/{$recipeIdArg}"
}

@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterialApi::class)
@Composable
fun RecipeScreen(
    modifier: Modifier = Modifier,
    viewModel: RecipeViewModel = viewModel(factory = AppVMProvider.Factory),
    onSubmitReply:(String) -> Unit
) {
    val focusManager = LocalFocusManager.current

    var replyText by rememberSaveable { mutableStateOf("") }

    // TODO Why in Material but not Material3
    val scaffoldState = rememberBackdropScaffoldState(BackdropValue.Revealed)
    val screenHeight = LocalConfiguration.current.screenHeightDp.dp

    val recipeUiState = viewModel.uiState.collectAsState()

    Box(modifier = modifier.fillMaxSize()) {
        BackdropScaffold(
            peekHeight = 0.dp,
            headerHeight = 0.dp,
            scaffoldState = scaffoldState,
            appBar = { },
            backLayerContent = {
                BoxWithConstraints(
                    modifier = modifier
                        .fillMaxHeight(0.35f)
                        .fillMaxWidth()
                        .clip(MaterialTheme.shapes.medium)
                ) {
                    val height = if (maxHeight > screenHeight / 2) screenHeight / 2 else maxHeight
                    Image(
                        painter = painterResource(recipeUiState.value.imageResId),
                        contentDescription = null,
                        modifier = modifier
                            .height(height)
                            .fillMaxWidth(),
                        contentScale = ContentScale.Crop
                    )
                }
            },
            frontLayerContent = {
                BoxWithConstraints(
                    modifier = modifier
                        .fillMaxSize()
                ){
                    val constraints = maxHeight / 2
                    val height = if (constraints > screenHeight / 2) screenHeight / 2 else constraints
                    Column(
                        modifier = modifier
                            .fillMaxSize()
                            .padding(16.dp)
                            .height(height),
                        verticalArrangement = Arrangement.spacedBy(10.dp)
                    ) {
                        Row(
                            verticalAlignment = Alignment.CenterVertically
                        ) {
                            Text(
                                text =  recipeUiState.value.title,
                                style = MaterialTheme.typography.titleSmall,
                                maxLines = 2
                            )
                            Spacer(modifier = Modifier.weight(1f))
                            Icon(Icons.Filled.Favorite, contentDescription =null)
                        }
                        IngredientsArea()
                        DirectionsArea()
                        CommentSection(
                            recipeUiState.value.comments
                            /*Comment(R.drawable.profilepic, "Njogu", "Whack"),
                            Comment(R.drawable.profilepic, "Karuchiu", "Comida Interesante"),
                            Comment(R.drawable.profilepic, "Njogu", "Whack"),
                            Comment(R.drawable.profilepic, "Karuchiu", "Comida Interesante"),
                            Comment(R.drawable.profilepic, "Njogu", "Whack"),
                            Comment(R.drawable.profilepic, "Karuchiu", "Comida Interesante"),
                            Comment(R.drawable.profilepic, "Njogu", "Whack"),
                            Comment(R.drawable.profilepic, "Karuchiu", "Comida Interesante")*/,
                            reply = replyText,
                            onValueChange = {replyText = it},
                            label = R.string.write_comment,
                            keyboardOptions = KeyboardOptions(
                                keyboardType = KeyboardType.Text,
                                imeAction = ImeAction.Done
                            ),
                            keyboardActions = KeyboardActions(
                                onNext = {focusManager.clearFocus()}
                            ),
                            onSubmitReply = {onSubmitReply(replyText)}
                        )
                    }
                }
            },
        )

    }
}