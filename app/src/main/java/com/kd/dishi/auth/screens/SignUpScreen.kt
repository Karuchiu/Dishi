package com.kd.dishi.auth.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusDirection
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.kd.dishi.R
import com.kd.dishi.components.CButton
import com.kd.dishi.components.CDivider
import com.kd.dishi.components.COutlinedTextField
import com.kd.dishi.components.HaveAccRow
import com.kd.dishi.ui.theme.LemonMilkFontFamily

@Composable
fun SignUpScreen(
    registerBtnClick:() -> Unit,
    loginButtonClick: () -> Unit
) {
    val focusManager = LocalFocusManager.current

    var firstName by rememberSaveable {
        mutableStateOf("")
    }

    var lastName by rememberSaveable {
        mutableStateOf("")
    }

    var email by rememberSaveable {
        mutableStateOf("")
    }

    var password by rememberSaveable {
        mutableStateOf("")
    }

    var confirmPassword by rememberSaveable {
        mutableStateOf("")
    }

    //TODO ProvideWindowInsets
    Surface(
        color = Color(0xFF005900)
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 24.dp)
        ) {
            Text(
                text = stringResource(id = R.string.create_acc),
                style = TextStyle(
                    fontSize = 24.sp,
                    fontFamily = LemonMilkFontFamily,
                    fontWeight = FontWeight(500),
                    color = Color.White
                )
            )

            Text(
                text = stringResource(id = R.string.reg_details),
                style = TextStyle(
                    fontSize = 16.sp,
                    fontFamily = LemonMilkFontFamily,
                    fontWeight = FontWeight.Light,
                    color = Color.White
                ),
                modifier = Modifier
                    .padding(bottom = 24.dp)
            )

            COutlinedTextField(
                value = firstName ,
                onValueChange = {firstName = it},
                label = R.string.first_name,
                icon = Icons.Default.Person,
                iconDesc = "Person Icon",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                visualTransformation = VisualTransformation.None,
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                )
            )

            COutlinedTextField(
                value = lastName ,
                onValueChange = {lastName = it},
                label = R.string.last_name,
                icon = Icons.Default.Person,
                iconDesc = "Person Icon",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next
                ),
                visualTransformation = VisualTransformation.None,
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                )
            )

            COutlinedTextField(
                value = email ,
                onValueChange = {email = it},
                label = R.string.email_address,
                icon = Icons.Default.Email,
                iconDesc = "Email Icon",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Email
                ),
                visualTransformation = VisualTransformation.None,
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                )
            )

            COutlinedTextField(
                value = password ,
                onValueChange = {password = it},
                label = R.string.password,
                icon = Icons.Default.Lock,
                iconDesc = "Email Icon",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Next,
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.moveFocus(FocusDirection.Down)}
                )
            )

            COutlinedTextField(
                value = confirmPassword ,
                onValueChange = {confirmPassword = it},
                label = R.string.confirm_password,
                icon = Icons.Default.Lock,
                iconDesc = "Password Icon",
                keyboardOptions = KeyboardOptions(
                    imeAction = ImeAction.Done,
                    keyboardType = KeyboardType.Password
                ),
                visualTransformation = PasswordVisualTransformation(),
                keyboardActions = KeyboardActions(
                    onNext = {focusManager.clearFocus()}
                )
            )

            Spacer(modifier = Modifier.height(24.dp))

            CButton(
                text = stringResource(id = R.string.sign_up)
            ){
                registerBtnClick()
            }

            CDivider()

            HaveAccRow(
                R.string.have_acc,
                R.string.sign_in
            ){
                loginButtonClick()
            }
        }
    }
}

@Preview(showBackground = true, widthDp = 320, heightDp = 640)
@Composable
fun SignUPScreenPrev() {
    SignUpScreen(
        registerBtnClick = {},
        loginButtonClick = {}
    )
}