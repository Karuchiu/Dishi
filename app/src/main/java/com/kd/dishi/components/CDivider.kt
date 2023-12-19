package com.kd.dishi.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CDivider() {
    Divider(
        color = Color.White.copy(alpha = 0.3f),
        thickness = 1.dp,
        modifier = Modifier.padding(top = 32.dp)
    )
}