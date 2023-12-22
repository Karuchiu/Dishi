package com.kd.dishi.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.annotation.StringRes
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Text
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.kd.dishi.models.Comment
import com.kd.dishi.R

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CommentSection(
    comments: List<Comment>?,
    reply: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    onSubmitReply: (String) -> Unit
) {
    Text(
        text = stringResource(id = R.string.comments),
        style = MaterialTheme.typography.labelLarge
    )
    ReplyTextField(
        reply = reply,
        onValueChange = onValueChange,
        label = label,
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        onSubmitReply = onSubmitReply
    )
    LazyColumn(
        modifier = Modifier.fillMaxHeight(),
        verticalArrangement = Arrangement.spacedBy(10.dp)
    ){
        if (comments != null) {
            items(comments.size){ index ->
                CommentCard(
                    comment = Comment(
                        comments[index].comment,
                        comments[index].curator,
                        //comments[index].recipe
                    )
                )
            }
        }
    }
}