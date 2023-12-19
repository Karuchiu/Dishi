package com.kd.dishi.components

import androidx.annotation.StringRes
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kd.dishi.ui.theme.LemonMilkFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun COutlinedTextField(
    value: String,
    onValueChange: (String) -> Unit,
    @StringRes label: Int,
    icon: ImageVector,
    iconDesc: String,
    keyboardOptions: KeyboardOptions,
    keyboardActions: KeyboardActions,
    visualTransformation: VisualTransformation
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = stringResource(label),
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = LemonMilkFontFamily,
                    color = Color(0xFFBEC2C2)
                )
            )
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = TextFieldDefaults.textFieldColors(
            containerColor = Color.Transparent,
            focusedIndicatorColor = Color(0xFFBEC2C2),
            unfocusedIndicatorColor = Color(0xFFBEC2C2)
        ),
        leadingIcon = {
            Icon(imageVector = icon, contentDescription = iconDesc)
        },
        keyboardOptions = keyboardOptions,
        keyboardActions = keyboardActions,
        visualTransformation = visualTransformation,
        singleLine = true
    )
}