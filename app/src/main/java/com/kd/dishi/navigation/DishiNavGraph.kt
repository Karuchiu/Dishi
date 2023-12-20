package com.kd.dishi.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.navigation.NavOptions
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.kd.dishi.auth.screens.LoginScreen
import com.kd.dishi.auth.screens.SignUpScreen
import com.kd.dishi.auth.screens.SuccessScreen
import com.kd.dishi.auth.screens.UploadDpScreen
import com.kd.dishi.auth.screens.WelcomeScreen
import kotlinx.coroutines.delay

enum class AuthScreens {
    Welcome,
    Register,
    Login,
    UploadDp,
    Success
}

@Composable
fun DishiApp() {
    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = AuthScreens.Welcome.name
    ){

        composable(route = AuthScreens.Welcome.name){
            WelcomeScreen()
            LaunchedEffect(Unit) {
                delay(2000)
                navController.navigate(
                    route = AuthScreens.Login.name,
                    navOptions = NavOptions.Builder()
                        .setPopUpTo(AuthScreens.Welcome.name, true)
                        .build()
                )
            }
        }

        composable(route = AuthScreens.Login.name){
            LoginScreen(
                loginButtonClick = {

                },
                registerBtnClick = {
                    navController.navigate(AuthScreens.Register.name)
                }
            )
        }

        composable(route = AuthScreens.Register.name){
            SignUpScreen(
                registerBtnClick = {
                    navController.navigate(AuthScreens.UploadDp.name)
                },
                loginButtonClick = {
                    navController.navigate(AuthScreens.Login.name)
                }
            )
        }

        composable(AuthScreens.UploadDp.name){
            UploadDpScreen(){
                navController.navigate(AuthScreens.Success.name)
            }
        }

        composable(AuthScreens.Success.name){
            SuccessScreen(){
                navController.navigate(AuthScreens.Login.name)
            }
        }
    }
}