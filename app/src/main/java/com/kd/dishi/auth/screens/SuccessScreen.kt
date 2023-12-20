package com.kd.dishi.auth.screens

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.ui.graphics.Color
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kd.dishi.R
import com.kd.dishi.ui.theme.Green8B
import com.kd.dishi.ui.theme.IconGreen
import com.kd.dishi.ui.theme.LemonMilkFontFamily
import com.kd.dishi.ui.theme.ThemeGreen

@Composable
fun SuccessScreen(
    modifier: Modifier = Modifier,
    getStartedBtnClick: () -> Unit = {}
) {
    Column(
        modifier = modifier
            //.background(MaterialTheme.colorScheme.background)
            .fillMaxSize()
            .padding(horizontal = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.SpaceEvenly
    ) {
        SuccessHeader(modifier.height(150.dp))
        CongratsText()
        GradientButton(
            text = stringResource(id = R.string.get_started),
            textColor = White,
            gradient = Brush.linearGradient(
                colors = listOf(
                    IconGreen,
                    ThemeGreen
                )
            ),
            onClick = getStartedBtnClick
        )
    }
}

@Composable
fun SuccessHeader(
    modifier: Modifier = Modifier
) {
    Box(
        modifier = modifier,
        contentAlignment = Alignment.BottomCenter
    ) {
        Image(
            painter = painterResource(id = R.drawable.pattern),
            contentDescription = "Success Background",
            modifier = modifier
                .scale(2.70f, 1.4f)
                .fillMaxSize()
        )

        Image(
            painter = painterResource(id = R.drawable.congratulations),
            contentDescription = "Success Image",
            modifier = modifier
        )

    }

}

@Composable
fun CongratsText() {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.congrats),
            style = TextStyle(
                fontSize = 24.sp,
                fontFamily = LemonMilkFontFamily,
                fontWeight = FontWeight(500),
                color = Green8B
            )
        )
        Spacer(modifier = Modifier.height(5.dp))

        Text(
            text = stringResource(id = R.string.ready_profile),
            style = MaterialTheme.typography.titleMedium,
        )
    }
}

@Composable
fun GradientButton(
    text: String,
    textColor: Color,
    gradient: Brush,
    onClick: () -> Unit
) {
    Button(
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent
        ),
        contentPadding = PaddingValues(),
        onClick = onClick
    ) {
        Box(
            modifier = Modifier
                .background(gradient)
                .padding(16.dp, 8.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text,
                style = MaterialTheme.typography.labelLarge,
                color = textColor
            )
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Preview(
    showBackground = true,
    showSystemUi = true
)
@Composable
fun SuccessScreenPreview() {
    SuccessScreen()
}