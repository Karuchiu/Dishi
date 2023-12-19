package com.kd.dishi.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun HaveAccRow(
    @StringRes acc: Int,
    @StringRes textBtn: Int
) {
    Row (
        modifier = Modifier.padding(top = 12.dp, bottom = 48.dp),
        verticalAlignment = Alignment.CenterVertically
    ){
        Text(
            text = stringResource(acc),
            style = TextStyle(
                fontSize = 18.sp,
                color = Color.White
            )
        )
        
        Spacer(modifier = Modifier.weight(1f))
        
        TextButton(
            onClick = {},
        ){
            Text(
                text = stringResource(textBtn),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontWeight = FontWeight(800),
                    color = Color.White
                )
            )
        }
    }
}