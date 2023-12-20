package com.kd.dishi.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import com.kd.dishi.R
import com.kd.dishi.models.Curator

@Composable
fun CuratorCard(
    curator: Curator,
    modifier: Modifier = Modifier,
    curatorOnClick: (Curator) -> Unit
) {
    CardItem(
        imageURL = curator.curatorImage,
        title = stringResource(id = R.string.full_name, curator.firstName, curator.lastName),
        onClick = { curatorOnClick(curator) },
        modifier = modifier
    )
}