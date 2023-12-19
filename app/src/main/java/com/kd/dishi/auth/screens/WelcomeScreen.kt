package com.kd.dishi.auth.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kd.dishi.R
import com.kd.dishi.ui.theme.UrbanJungleFamily

@Composable
fun WelcomeScreen(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Column(
           //horizontalAlignment = Alignment.CenterHorizontally,
            //verticalArrangement = Arrangement.Center,
            modifier = modifier
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.app_name),
                style = TextStyle(
                    fontSize = 100.sp,
                    fontFamily = UrbanJungleFamily,
                    fontWeight = FontWeight(900),
                    color = Color.Black,
                    letterSpacing = 4.sp
                )
            )
        }
    }
}


@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun WelcomeScreenPrev() {
    WelcomeScreen()
}