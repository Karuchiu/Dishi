package com.kd.dishi.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.R
import com.kd.dishi.models.Curator

@Composable
fun CuratorCard(
    curator: Curator,
    modifier: Modifier = Modifier,
    curatorOnClick: (Curator) -> Unit
) {
    Card(
        modifier = modifier
            .clip(RoundedCornerShape(4.dp))
            .size(180.dp)
            .clickable { curatorOnClick(curator) }
    ) {
        Column(
            modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceAround
        ) {
            Image(
                modifier = modifier.size(80.dp),
                painter = painterResource(id = curator.curatorImage),
                contentDescription = null
            )
            Text(
                text = stringResource(id = R.string.full_name, curator.firstName, curator.lastName),
                style = MaterialTheme.typography.labelLarge
            )
        }
    }
}