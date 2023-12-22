package com.kd.dishi.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import java.time.Instant
import java.util.Date
import com.kd.dishi.R
import com.kd.dishi.models.Comment

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CommentCard(
    comment: Comment,
    modifier: Modifier = Modifier
){
    androidx.compose.material3.Card {
        Row {
            painterResource(id = comment.curator.curatorImage ).let {
                Icon(
                    painter = it,
                    contentDescription = null
                )
            }

            Column(
                modifier.padding(8.dp)
            ) {
                Text(
                    text = stringResource(id = R.string.full_name,
                        comment.curator.firstName, comment.curator.lastName
                    ) ,
                    style = MaterialTheme.typography.labelLarge
                )
                Text(
                    // RequiresApi(O) Annotation
                    text = Date.from(Instant.now()).toString(),
                    style = MaterialTheme.typography.labelSmall
                )

                Text(
                    text = comment.comment,
                    style = MaterialTheme.typography.labelMedium,
                    maxLines = 4
                )
            }
        }
    }
}