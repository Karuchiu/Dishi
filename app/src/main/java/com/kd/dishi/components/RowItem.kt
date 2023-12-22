package com.kd.dishi.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun <T> RowItem(
    items: List<T>,
    onItemClick: (T) -> Unit,
    content: @Composable (T, onItemClick: (T) -> Unit) -> Unit
) {
    LazyRow(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ){
        items(count = items.size, key = {it}){index ->
            content(items[index]){ item ->
                onItemClick(item)
            }
        }
    }
}