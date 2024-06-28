package com.example.easppb

sealed class Screen(val route: String){
    object LoginScreen: Screen("login_screen")
    object RegisterScreen: Screen("register_screen")
    object HomeScreen: Screen("home_screen")
    object ProfileScreen: Screen("profile_screen")
    object TopupScreen: Screen("topup_screen")
    object TopupConfirmScreen: Screen("topup_confirm_screen")
    object TopupSuccessScreen: Screen("topup_success_screen")

    fun withArgs(vararg args: String): String {
        return buildString {
            append(route)
            args.forEach { arg ->
                append("/$arg")
            }
        }
    }
}