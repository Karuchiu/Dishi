package com.kd.dishi.auth.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kd.dishi.R
import com.kd.dishi.ui.theme.LemonMilkFontFamily

@Composable
fun UploadDpScreen(
    onNextButtonClicked: () -> Unit = {}
) {
    /* var profilePicture by remember{
         mutableStateOf(R.drawable.profilepic)
     }*/

    //TODO ProvideWindowInsets
    Surface(
        color = Color(0xFF005900)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Spacer(modifier = Modifier.weight(1f))
            UserUpload(
                onNextButtonClicked = onNextButtonClicked
                //profilePic = profilePicture
            )
            Spacer(modifier = Modifier.weight(1f))
        }
    }

}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    name = "Upload Picture Preview",
    showBackground = true,
    showSystemUi = true
)
@Composable
fun UploadPicturePreview() {
    UploadDpScreen()
}

@Composable
fun UserUpload(
    modifier: Modifier = Modifier,
    onNextButtonClicked: () -> Unit
    //profilePic: Int
) {
    Column(
        verticalArrangement = Arrangement.spacedBy(30.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.upload_picture),
            style = TextStyle(
                fontSize = 28.sp,
                fontFamily = LemonMilkFontFamily,
                fontWeight = FontWeight(500),
                color = Color.White
            )
        )
        Image(
            painter = painterResource(id = R.drawable.profilepic),
            contentDescription = null,
            modifier = Modifier
                .size(300.dp)
        )
        Text(
            text = stringResource(id = R.string.upload_data),
            style = TextStyle(
                fontSize = 18.sp,
                fontFamily = LemonMilkFontFamily,
                fontWeight = FontWeight(500),
                color = Color.White
            )
        )
        Button(
            onClick = onNextButtonClicked,
            modifier = modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(
                text = stringResource(id = R.string.next),
                style = MaterialTheme.typography.labelLarge
                /**
                 * MaterialTheme vs TextStyle
                 */
            )
        }
    }
}