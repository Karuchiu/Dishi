package com.kd.dishi.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.R
import com.kd.dishi.models.Curator

@Composable
fun CuratorRow(
    curators: List<Curator>,
    curatorOnClick: (Curator) -> Unit
) {
    /*RowItem(items = curators, onItemClick = curatorOnClick) { curator, onItemClick ->
        CuratorCard(curator = curator, curatorOnClick = onItemClick)
    }*/
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(curators.size){
            CuratorCard(
                curator = curators[it],
                curatorOnClick = curatorOnClick
            )
        }
    }
}

@Composable
fun PopularCurators(
    curatorList: List<Curator>,
    modifier: Modifier = Modifier,
    curatorOnClick: (Curator) -> Unit = {}
) {

    /*TitledList(
        items = curatorList,
        title = R.string.top_curators,
        onItemClick = curatorOnClick,
        modifier = modifier
    ) { curators, onCuratorClick ->
        CuratorRow(
            curators = curators,
            curatorOnClick = onCuratorClick
        )
    }*/
    Column {
        Row(
            modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Text(
                text = stringResource(id = R.string.top_curators),
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = modifier.weight(1f))
        }

        CuratorRow(
            curators = curatorList,
            curatorOnClick = curatorOnClick
        )
    }
}