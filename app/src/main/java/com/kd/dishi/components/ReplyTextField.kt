package com.kd.dishi.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.TextField
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp

@Composable
fun ReplyTextField(
    reply: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    onSubmitReply: (String) -> Unit
) {
    Column {
        TextField(
            value = reply,
            onValueChange = onValueChange,
            label = {
                Text(
                    text = stringResource(id = label),
                    style = MaterialTheme.typography.labelMedium
                )
            },
            keyboardOptions = keyboardOptions,
            keyboardActions = keyboardActions,
            modifier = Modifier
                .fillMaxWidth()
                .defaultMinSize(minHeight = 70.dp),
            maxLines = 3
        )

        Button(
            onClick = {onSubmitReply(reply)},
            modifier = Modifier.align(Alignment.End)
        ) {
            Text("Submit")
        }
    }
}