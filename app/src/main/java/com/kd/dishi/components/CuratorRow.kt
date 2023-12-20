package com.kd.dishi.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.kd.dishi.R
import com.kd.dishi.models.Curator

@Composable
fun CuratorRow(
    curators: List<Curator>,
    curatorOnClick: (Curator) -> Unit
) {
    RowItem(items = curators, onItemClick = curatorOnClick) { curator, onItemClick ->
        CuratorCard(curator = curator, curatorOnClick = onItemClick)
    }
}

@Composable
fun PopularCurators(
    curatorList: List<Curator>,
    modifier: Modifier = Modifier,
    curatorOnClick: (Curator) -> Unit = {}
) {

    TitledList(
        items = curatorList,
        title = R.string.top_curators,
        onItemClick = curatorOnClick,
        modifier = modifier
    ) { curators, onCuratorClick ->
        CuratorRow(
            curators = curators,
            curatorOnClick = onCuratorClick
        )
    }
}