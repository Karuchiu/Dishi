package com.kd.dishi.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.R

@Composable
fun DirectionsArea() {
    Column {
        Text(
            text = stringResource(id = R.string.directions),
            style = MaterialTheme.typography.labelLarge
        )
        Text(
            text = stringResource(id = R.string.directions_example),
            style = MaterialTheme.typography.bodySmall,
            softWrap = true,
            modifier = Modifier.padding(start = 10.dp)
        )
    }
}