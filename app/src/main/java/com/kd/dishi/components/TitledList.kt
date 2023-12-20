package com.kd.dishi.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun <T> TitledList(
    modifier: Modifier = Modifier,
    items: List<T>,
    title: Int,
    onItemClick: (T) -> Unit,
    content: @Composable (List<T>, onItemClick: (T) -> Unit) -> Unit
) {
    Column {
        Row(
            modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp)
        ) {
            Text(
                text = stringResource(title),
                style = MaterialTheme.typography.labelMedium
            )
            Spacer(modifier = modifier.weight(1f))
        }

        content(items, onItemClick)
    }
}